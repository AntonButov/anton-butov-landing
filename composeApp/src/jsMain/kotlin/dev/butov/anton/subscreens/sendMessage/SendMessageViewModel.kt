package dev.butov.anton.subscreens.sendMessage

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SendMessageViewModel(
    private val repository: SendMessageRepository = FormspreeSendMessageRepository(),
) : ViewModel() {
    var state: SendMessageState by mutableStateOf(SendMessageState.Edit("", "", ""))
        private set

    var name: String
        get() = (state as SendMessageState.Edit).name
        private set(value) {
            state = (state as SendMessageState.Edit).copy(name = value)
        }

    var email: String
        get() = (state as SendMessageState.Edit).email
        private set(value) {
            state = (state as SendMessageState.Edit).copy(email = value)
        }

    var message: String
        get() = (state as SendMessageState.Edit).message
        private set(value) {
            state = (state as SendMessageState.Edit).copy(message = value)
        }

    var error: Error?
        get() = (state as SendMessageState.Edit).error
        private set(value) {
            state = (state as SendMessageState.Edit).copy(error = value)
        }

    fun onNameChange(value: String) {
        name = value
    }

    fun onEmailChange(value: String) {
        if (error == Error.Email) {
            error = null
        }
        email = value
    }

    fun onMessageChange(value: String) {
        if (error == Error.Message) {
            error = null
        }
        message = value
    }

    fun send() {
        if (email.isEmpty() || email.isBlank()) {
            error = Error.Email
            return
        }
        if (message.isEmpty() || message.isBlank()) {
            error = Error.Message
            return
        }
        viewModelScope.launch {
            runCatching {
                when (val result = repository.send(name, email, message)) {
                    NetResult.Success -> state = SendMessageState.Ok
                    NetResult.WrongEmail -> error = Error.Email
                    is NetResult.UnkownError -> state = SendMessageState.UnknounError(result.message)
                }
            }.onFailure {
                state = SendMessageState.UnknounError(it.message.toString())
            }
        }
    }
}

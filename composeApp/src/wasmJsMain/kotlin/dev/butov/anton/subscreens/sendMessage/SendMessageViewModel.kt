package dev.butov.anton.subscreens.sendMessage

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class SendMessageViewModel {
    var state: SendMessageState by mutableStateOf(SendMessageState.Edit("", "", ""))
        private set

    var name: String
        get() = (state as SendMessageState.Edit).name
        private set(value) {
            state = (state as SendMessageState.Edit).copy(name = value, isError = false)
        }

    var email: String
        get() = (state as SendMessageState.Edit).email
        private set(value) {
            state = (state as SendMessageState.Edit).copy(email = value, isError = false)
        }

    var message: String
        get() = (state as SendMessageState.Edit).message
        private set(value) {
            state = (state as SendMessageState.Edit).copy(message = value, isError = false)
        }

    val isError: Boolean
        get() = (state as SendMessageState.Edit).isError

    fun onNameChange(value: String) {
        name = value
    }

    fun onEmailChange(value: String) {
        email = value
    }

    fun onMessageChange(value: String) {
        message = value
    }
}

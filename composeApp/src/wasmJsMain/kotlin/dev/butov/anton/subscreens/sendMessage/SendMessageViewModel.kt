package dev.butov.anton.subscreens.sendMessage

import androidx.compose.runtime.*

class SendMessageViewModel {
    var name by mutableStateOf("")
        private set
    var email by mutableStateOf("")
        private set
    var message by mutableStateOf("")
        private set

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
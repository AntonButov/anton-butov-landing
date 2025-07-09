package dev.butov.anton.subscreens.sendMessage

sealed interface SendMessageState {
    object Idle: SendMessageState
    data class Edit(
        val name: String,
        val email: String,
        val message: String
    ) : SendMessageState
    object Error: SendMessageState
    object Ok: SendMessageState
}
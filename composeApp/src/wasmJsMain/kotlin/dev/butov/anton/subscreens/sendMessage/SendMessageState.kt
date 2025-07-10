package dev.butov.anton.subscreens.sendMessage

sealed interface SendMessageState {
    object Error : SendMessageState
    object Ok : SendMessageState

    data class Edit(
        val name: String,
        val email: String,
        val message: String,
        val isError: Boolean
    ) : SendMessageState
}
package dev.butov.anton.subscreens.sendMessage

sealed interface SendMessageState {
    data object Ok : SendMessageState

    data class UnknounError(val message: String) : SendMessageState

    data class Edit(
        val name: String,
        val email: String,
        val message: String,
        val error: Error? = null,
    ) : SendMessageState
}

enum class Error {
    Email,
    Message,
}

package dev.butov.anton.subscreens.sendMessage

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

/** View model controlling SendMessage screen state. */
class SendMessageViewModel {
    /** Current state of the screen. */
    var state: SendMessageState by mutableStateOf(SendMessageState.Edit("", "", ""))
        private set

    /** Current name value from [state] or empty if not editing. */
    val name: String
        get() = (state as? SendMessageState.Edit)?.name ?: ""

    /** Current email value from [state] or empty if not editing. */
    val email: String
        get() = (state as? SendMessageState.Edit)?.email ?: ""

    /** Current message value from [state] or empty if not editing. */
    val message: String
        get() = (state as? SendMessageState.Edit)?.message ?: ""

    /** Update name when in [SendMessageState.Edit] state. */
    fun onNameChange(value: String) {
        val current = state
        if (current is SendMessageState.Edit) {
            state = current.copy(name = value)
        }
    }

    /** Update email when in [SendMessageState.Edit] state. */
    fun onEmailChange(value: String) {
        val current = state
        if (current is SendMessageState.Edit) {
            state = current.copy(email = value)
        }
    }

    /** Update message when in [SendMessageState.Edit] state. */
    fun onMessageChange(value: String) {
        val current = state
        if (current is SendMessageState.Edit) {
            state = current.copy(message = value)
        }
    }}

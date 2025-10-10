package dev.butov.anton.subscreens.sendMessage

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SendMessageBlock(modifier: Modifier = Modifier) {
    val viewModel = remember { SendMessageViewModel() }
    Box(modifier) {
        when (val state = viewModel.state) {
            is SendMessageState.Edit -> InputBlock(viewModel)
            is SendMessageState.Ok -> Ok()
            is SendMessageState.UnknounError -> Wrong(state.message)
        }
    }
}

package dev.butov.anton.subscreens.burger

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.Composable
import io.ktor.websocket.Frame

@Composable
fun Hamburger(viewModel: MenuViewModel) {
    Box {
        DropdownMenu(
            expanded = viewModel.isMenuOpen,
            onDismissRequest = viewModel::onDismissMenu,
        ) {
            MenuItem.entries.forEach { item ->
                DropdownMenuItem(
                    text = { Frame.Text(item.title) },
                    onClick = { viewModel.onMenuItemClick(item) },
                )
            }
        }
    }
}

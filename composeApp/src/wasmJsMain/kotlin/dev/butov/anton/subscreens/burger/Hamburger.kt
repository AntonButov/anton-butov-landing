package dev.butov.anton.subscreens.burger

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import dev.butov.anton.myiconpack.AntonIcons
import dev.butov.anton.myiconpack.Gamburger
import io.ktor.websocket.Frame

@Composable
fun Hamburger(viewModel: MenuViewModel) {
    Box {
        IconButton(onClick = viewModel::onHamburgerClick) {
            Icon(
                imageVector = AntonIcons.Gamburger,
                contentDescription = "Gamburger",
            )
        }
        DropdownMenu(
            expanded = viewModel.isMenuOpen,
            onDismissRequest = viewModel::onDismissMenu,
        ) {
            MenuItem.values().forEach { item ->
                DropdownMenuItem(
                    text = { Frame.Text(item.title) },
                    onClick = { viewModel.onMenuItemClick(item) },
                )
            }
        }
    }
}

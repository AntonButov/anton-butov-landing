package dev.butov.anton.subscreens.burger

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.butov.anton.Colors

@Composable
fun HamburgerMenu(viewModel: MenuViewModel) {
    Box {
        DropdownMenu(
            modifier = Modifier.width(300.dp),
            expanded = viewModel.isMenuOpen,
            onDismissRequest = viewModel::onDismissMenu,
            shape = MaterialTheme.shapes.medium,
        ) {
            MenuItem.entries.forEach { item ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = item.title,
                            color = if (item.index == 0) Colors.red else Colors.background,
                            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Medium),
                        )
                    },
                    onClick = { viewModel.onMenuItemClick(item) },
                )
            }
        }
    }
}

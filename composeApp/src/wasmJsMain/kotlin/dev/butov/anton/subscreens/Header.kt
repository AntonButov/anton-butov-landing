package dev.butov.anton.subscreens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.butov.anton.myiconpack.AntonButov
import dev.butov.anton.myiconpack.AntonIcons
import dev.butov.anton.myiconpack.Arrow
import dev.butov.anton.myiconpack.Gamburger
import dev.butov.anton.uikit.CallButtonDark

@Composable
fun Header(viewModel: MenuViewModel) {
    Box(
        Modifier
            .height(50.dp)
            .fillMaxWidth(),
    ) {
        Hamburger(viewModel)
        Arrows()
        AntonButov(Modifier.align(Alignment.Center))
        CallButtonDark(Modifier.align(Alignment.CenterEnd))
    }
}

@Composable
private fun Hamburger(viewModel: MenuViewModel) {
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
                    text = { Text(item.title) },
                    onClick = { viewModel.onMenuItemClick(item) },
                )
            }
        }
    }
}

@Composable
private fun BoxScope.Arrows() {
    Row(
        modifier = Modifier.align(Alignment.Center),
    ) {
        Arrow()
        Arrow()
    }
}

@Composable
private fun Arrow() {
    Icon(
        imageVector = AntonIcons.Arrow,
        contentDescription = "Arrow",
    )
}

@Composable
fun BoxScope.AntonButov(modifier: Modifier) {
    Icon(
        modifier = modifier,
        imageVector = AntonIcons.AntonButov,
        contentDescription = "AntonButov",
    )
}

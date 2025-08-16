package dev.butov.anton.subscreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.butov.anton.myiconpack.*
import dev.butov.anton.subscreens.burger.MenuViewModel
import dev.butov.anton.uikit.CallButtonDark

@Composable
fun Header(menuViewModel: MenuViewModel) {
    Box(
        Modifier
            .height(50.dp)
            .fillMaxWidth(),
    ) {
        Hamburger(menuViewModel)
        Arrows()
        AntonButov(Modifier.align(Alignment.Center))
        CallButtonDark(Modifier.align(Alignment.CenterEnd))
    }
}

@Composable
private fun Hamburger(viewModel: MenuViewModel) {
    Icon(
        modifier = Modifier.clickable(onClick = viewModel::onHamburgerClick),
        imageVector = if (viewModel.isMenuOpen) AntonIcons.HamburgerCross else AntonIcons.Hamburger,
        contentDescription = "Gamburger",
    )
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
fun AntonButov(modifier: Modifier) {
    Icon(
        modifier = modifier,
        imageVector = AntonIcons.AntonButov,
        contentDescription = "AntonButov",
    )
}

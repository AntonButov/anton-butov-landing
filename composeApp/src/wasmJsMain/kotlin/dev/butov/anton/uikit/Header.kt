package dev.butov.anton.uikit

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import antonbutov.composeapp.generated.resources.Res
import antonbutov.composeapp.generated.resources.go
import dev.butov.anton.Colors
import dev.butov.anton.myiconpack.AntonButov
import dev.butov.anton.myiconpack.AntonIcons
import dev.butov.anton.myiconpack.Arrow
import dev.butov.anton.myiconpack.Gamburger
import org.jetbrains.compose.resources.painterResource

@Composable
fun Header() {
    Box(
        Modifier
            .height(50.dp)
            .fillMaxWidth(),
    ) {
        Hamburger()
        Arrows()
        AntonButov()
        CallButtonDark(Modifier.align(Alignment.CenterEnd))
    }
}

@Composable
fun Hamburger() {
    Icon(
        imageVector = AntonIcons.Gamburger,
        contentDescription = "Gamburger",
    )
}

@Composable
fun BoxScope.Arrows() {
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
fun BoxScope.AntonButov() {
    Icon(
        modifier = Modifier.align(Alignment.Center),
        imageVector = AntonIcons.AntonButov,
        contentDescription = "AntonButov",
    )
}
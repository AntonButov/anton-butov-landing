package dev.butov.anton.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.butov.anton.Colors
import dev.butov.anton.myiconpack.AntonIcons
import dev.butov.anton.myiconpack.RectangleHard
import dev.butov.anton.myiconpack.RectangleSoft

@Composable
fun BoxScope.BackGroundRectangles() {
    Row(
        // Modifier
        //     .matchParentSize(),
    ) {
        Box(Modifier.weight(1f)) {
            Icon(
                modifier = Modifier.align(Alignment.TopStart).padding(start = 1.dp, top = 50.dp),
                imageVector = AntonIcons.RectangleSoft,
                contentDescription = null,
            )
            Icon(
                modifier = Modifier.align(Alignment.Center).padding(top = 130.dp),
                imageVector = AntonIcons.RectangleHard,
                contentDescription = null,
            )
        }
        Box(Modifier.weight(1f)) {
            Icon(
                modifier = Modifier.align(Alignment.TopStart).padding(top = 250.dp, start = 150.dp),
                imageVector = AntonIcons.RectangleSoft,
                contentDescription = null,
            )
            Icon(
                modifier = Modifier.align(Alignment.TopEnd).padding(top = 50.dp, end = 100.dp),
                imageVector = AntonIcons.RectangleHard,
                contentDescription = null,
            )
        }
        Box(Modifier.weight(1f)) {
            Icon(
                modifier = Modifier.align(Alignment.TopStart).padding(start = 140.dp, top = 50.dp),
                imageVector = AntonIcons.RectangleSoft,
                contentDescription = null,
            )
        }
        Spacer(Modifier.weight(1f))
    }
}

@Composable
fun BoxScope.BackLines() {
    Row(
        Modifier
            .matchParentSize(),
    ) {
        Divider()
        Spacer(Modifier.weight(1f))
        Divider()
        Spacer(Modifier.weight(1f))
        Divider()
        Spacer(Modifier.weight(1f))
        Divider()
        Spacer(Modifier.weight(1f))
        Divider()
    }
}

@Composable
private fun Divider() {
    VerticalDivider(color = Colors.primary.copy(alpha = 0.05f))
}

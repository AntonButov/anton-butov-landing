package dev.butov.anton.subscreens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import dev.butov.anton.Colors
import dev.butov.anton.myiconpack.AntonIcons
import dev.butov.anton.myiconpack.Teleg

@Composable
fun Footer() {
    Box(Modifier.height(150.dp).fillMaxWidth()) {
        AntonButov(Modifier.align(Alignment.CenterStart))
        Row(Modifier.align(Alignment.CenterEnd)) {
            Button {
                Icon(
                    AntonIcons.Teleg,
                    contentDescription = "telega",
                )
            }
        }
    }
}

@Composable
private fun Button(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Box(
        modifier =
            modifier
                .clip(MaterialTheme.shapes.small)
                .border(
                    width = 1.dp,
                    color = Colors.primary.copy(0.08f),
                    shape = MaterialTheme.shapes.small,
                ).height(70.dp).padding(horizontal = 25.dp),
        contentAlignment = Alignment.Center,
    ) {
        content()
    }
}

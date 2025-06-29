package dev.butov.anton.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.butov.anton.Colors
import dev.butov.anton.myiconpack.AntonIcons
import dev.butov.anton.myiconpack.Call

@Composable
fun CallButtonDark(modifier: Modifier) {
    CallButton(
        modifier = modifier.fillMaxHeight(),
        background = Colors.primary.copy(alpha = 0.1f),
        contentColor = Colors.primary,
        borderColor = Colors.primary.copy(alpha = 0.2f),
    )
}

@Composable
fun CallButtonLight(modifier: Modifier) {
    CallButton(
        modifier = modifier,
        background = Colors.primary,
        contentColor = Colors.background,
        borderColor = Colors.primary,
    )
}

@Composable
private fun CallButton(modifier: Modifier, background: Color, contentColor: Color, borderColor: Color) {
    Box(
        modifier = modifier
            .width(160.dp)
            .clip(MaterialTheme.shapes.small)
            .background(background)
            .border(1.dp, borderColor, MaterialTheme.shapes.small)
            .padding(horizontal = 7.dp, vertical = 6.dp),
    ) {
        Row(
            modifier =
            Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Assign a call",
                color = contentColor,
                style = MaterialTheme.typography.bodyMedium,
            )
            Icon(
                imageVector = AntonIcons.Call,
                contentDescription = "Phone Icon",
                tint = contentColor,
            )
        }
    }
}
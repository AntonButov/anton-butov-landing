package dev.butov.anton.uikit

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp

val TECHNOLOGY_HEIGHT = 110.dp
val TECHNOLOGY_WIDTH = 155.dp

@Composable
fun TechnologyHeader(
    modifier: Modifier = Modifier
) {
    Box(modifier.height(TECHNOLOGY_HEIGHT).width(TECHNOLOGY_WIDTH)) {
        Text(
            modifier = Modifier.align(Alignment.TopStart),
            text = "Technologies:",
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}
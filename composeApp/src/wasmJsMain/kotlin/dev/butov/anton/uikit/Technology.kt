package dev.butov.anton.uikit

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

val TECHNOLOGY_HEIGHT = 110.dp
val TECHNOLOGY_WIDTH = 155.dp

@Composable
fun Technology(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    Box(modifier.height(TECHNOLOGY_HEIGHT).width(TECHNOLOGY_WIDTH)) {
        content()
    }
}

@Composable
fun TechnologyHeader(
    modifier: Modifier = Modifier
) {
    Technology {
        Text(
            modifier = modifier.align(Alignment.TopStart),
            text = "Technologies:",
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@Composable
fun Technology(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    technology: String,
    experience: String
) {
    Technology {

    }
}


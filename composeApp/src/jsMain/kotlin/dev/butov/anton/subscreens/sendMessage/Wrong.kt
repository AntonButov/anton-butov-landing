package dev.butov.anton.subscreens.sendMessage

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import dev.butov.anton.Colors
import dev.butov.anton.LocalIsMobile

@Composable
fun BoxScope.Wrong(message: String) {
    val isMobile = LocalIsMobile.current
    Column(
        Modifier.align(Alignment.Center),
    ) {
        Text(
            text = "Some problem:",
            style =
                (if (isMobile) MaterialTheme.typography.displaySmall else MaterialTheme.typography.displayMedium)
                    .copy(fontWeight = FontWeight.Medium),
            color = Colors.red,
        )
        Text(
            text = message,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

package dev.butov.anton.subscreens.sendMessage

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import dev.butov.anton.Colors

@Composable
fun Wrong(message: String) {
    Column {
        Text(
            text = "Some problem:",
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Medium),
            color = Colors.red,
        )
        Text(
            text = message,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

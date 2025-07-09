package dev.butov.anton.subscreens.sendMessage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.butov.anton.myiconpack.AntonIcons
import dev.butov.anton.myiconpack.Ok

@Composable
fun Ok() {
    Row {
        Image(
            modifier = Modifier.padding(horizontal = 20.dp),
            imageVector = AntonIcons.Ok,
            contentDescription = null,
        )
        Text(
            text = "Your message has been successfully sent",
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Medium),
        )
    }
}

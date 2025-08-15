package dev.butov.anton.subscreens

import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import antonbutov.composeapp.generated.resources.Res
import antonbutov.composeapp.generated.resources.copyright
import org.jetbrains.compose.resources.painterResource

@Composable
fun Smirnov() {
    Row {
        Icon(
            modifier = Modifier.size(20.dp),
            painter = painterResource(Res.drawable.copyright),
            contentDescription = "Smirnov",
        )
        Spacer(Modifier.size(10.dp))
        Text(
            text = "Smirnov",
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface,
        )
    }
}

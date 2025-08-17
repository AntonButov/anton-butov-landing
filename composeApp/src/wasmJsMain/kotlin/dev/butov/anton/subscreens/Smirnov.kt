package dev.butov.anton.subscreens

import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import antonbutov.composeapp.generated.resources.Res
import antonbutov.composeapp.generated.resources.copyright
import dev.butov.anton.Colors
import dev.butov.anton.currentYear
import dev.butov.anton.myiconpack.AntonIcons
import dev.butov.anton.myiconpack.Ss
import org.jetbrains.compose.resources.painterResource

@Composable
fun Smirnov() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            modifier = Modifier.size(20.dp),
            painter = painterResource(Res.drawable.copyright),
            contentDescription = "Smirnov",
        )
        Spacer(Modifier.size(5.dp))
        Text(
            text = currentYear.toString(),
            style = MaterialTheme.typography.bodyLarge,
        )
        Spacer(Modifier.weight(1f))
        Text(
            text =
                "Design by\n" +
                    "Smirnov Studio",
            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Normal, fontSize = 10.sp),
            color = Colors.primary.copy(alpha = 0.6f),
            textAlign = TextAlign.End,
        )
        Spacer(Modifier.size(5.dp))
        Icon(
            imageVector = AntonIcons.Ss,
            contentDescription = "Smirnov",
            tint = Colors.primary,
        )
    }
}

package dev.butov.anton.subscreens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import antonbutov.composeapp.generated.resources.Res
import antonbutov.composeapp.generated.resources.butov
import dev.butov.anton.Colors
import dev.butov.anton.uikit.CallButtonLight
import dev.butov.anton.uikit.FullStyle
import dev.butov.anton.uikit.FullStyleUnderline
import dev.butov.anton.uikit.SoftStyle
import org.jetbrains.compose.resources.painterResource

@Composable
fun PhotoBlock() {
    Box(modifier = Modifier.height(550.dp).fillMaxWidth()) {
        Im(Modifier.align(Alignment.BottomStart))
        Icon(
            painter = painterResource(Res.drawable.butov),
            contentDescription = null,
            modifier =
                Modifier
                    .align(Alignment.BottomEnd),
            tint = Color.Unspecified,
        )
    }
}

@Composable
private fun Im(modifier: Modifier) {
    Column(modifier = modifier) {
        val firstText =
            buildAnnotatedString {
                SoftStyle {
                    append("I'm ")
                }
                FullStyle {
                    append("Anton Butov\n")
                }
                SoftStyle {
                    append("and I'm a ")
                }
                FullStyle {
                    append("Senior Android ")
                }
                FullStyleUnderline {
                    append("Developer")
                }
            }
        Text(
            text = firstText,
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Medium),
        )
        Spacer(Modifier.size(24.dp))
        val secondText = "Nice to meet you."
        Text(
            text = secondText,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Light,
            color = Colors.primary.copy(alpha = 0.6f),
        )
        Spacer(Modifier.size(24.dp))
        CallButtonLight()
    }
}

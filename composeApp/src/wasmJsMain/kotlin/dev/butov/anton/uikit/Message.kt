package dev.butov.anton.uikit

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import antonbutov.composeapp.generated.resources.AntonButovMessage
import antonbutov.composeapp.generated.resources.Res
import dev.butov.anton.Colors
import dev.butov.anton.myiconpack.AntonIcons
import dev.butov.anton.myiconpack.BrasesOn
import dev.butov.anton.myiconpack.BrasessOff
import org.jetbrains.compose.resources.painterResource

@Composable
fun Message(modifier: Modifier) {
    Column(modifier.fillMaxWidth(0.7f)) {
        Box(Modifier.height(140.dp).fillMaxWidth()) {
            Icon(
                modifier = Modifier.align(Alignment.BottomStart),
                imageVector = AntonIcons.BrasesOn,
                contentDescription = null,
            )
            Icon(
                modifier = Modifier.size(100.dp).align(Alignment.TopCenter),
                painter = painterResource(Res.drawable.AntonButovMessage),
                contentDescription = null,
                tint = Color.Unspecified,
            )
        }
        Text(
            text =
                buildAnnotatedString {
                    SoftStyle {
                        append("My mission is ")
                    }
                    FullStyle {
                        append("to organize a team ")
                    }
                    SoftStyle {
                        append("that leverages the most ")
                    }
                    FullStyle {
                        append("powerful capabilities ")
                    }
                    SoftStyle {
                        append("of Kotlin and modern frameworks, ")
                    }
                    FullStyle {
                        append("including AI tools.")
                    }
                },
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
        )
        Spacer(Modifier.size(70.dp))
        Box(Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier.align(Alignment.TopStart),
                text = "• Anton Butov",
                style = TextStyle.Default.copy(fontSize = 18.sp, fontWeight = FontWeight.Light),
            )
            Icon(
                modifier = Modifier.align(Alignment.TopEnd),
                imageVector = AntonIcons.BrasessOff,
                contentDescription = null,
                tint = Colors.red,
            )
        }
    }
}

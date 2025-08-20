package dev.butov.anton.subscreens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.butov.anton.Colors
import dev.butov.anton.LocalIsMobile
import dev.butov.anton.myiconpack.*
import dev.butov.anton.subscreens.sendMessage.SendMessageBlock
import dev.butov.anton.uikit.CallButtonLight
import dev.butov.anton.uikit.FullStyle
import dev.butov.anton.uikit.SoftStyle

@Composable
fun ContactMe() {
    val isMobile = LocalIsMobile.current
    if (isMobile) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(10.dp),
        ) {
            LeftColumn()
            Spacer(Modifier.size(40.dp))
            SendMessageBlock()
        }
    } else {
        Row(Modifier.height(280.dp)) {
            LeftColumn(Modifier.weight(1f))
            Spacer(Modifier.weight(0.5f).defaultMinSize(minWidth = 20.dp))
            SendMessageBlock(Modifier.weight(3f).align(Alignment.Bottom))
        }
    }
}

@Composable
private fun LeftColumn(modifier: Modifier = Modifier) {
    val isMobile = LocalIsMobile.current
    if (isMobile) {
        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ContactMeText()
            Spacer(Modifier.height(20.dp))
            IAmOpenText()
            Spacer(Modifier.height(20.dp))
            CallButtonLight { }
        }
    } else {
        Column(
            modifier = modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            ContactMeText()
            IAmOpenText()
            CallButtonLight(Modifier.align(Alignment.Start)) {}
        }
    }
}

@Composable
private fun ContactMeText() {
    Text(
        text =
            buildAnnotatedString {
                FullStyle {
                    append("Contact ")
                }
                SoftStyle {
                    append("me ")
                }
            },
        style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Medium),
    )
}

@Composable
private fun IAmOpenText() {
    val isMobile = LocalIsMobile.current
    Text(
        text = "I'm open to new connections, ideas, and opportunities that can help me grow. I'm also open to feedback.",
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.Light,
        textAlign = if (isMobile) TextAlign.Center else TextAlign.Start,
        color = Colors.primary.copy(alpha = 0.6f),
    )
}

package dev.butov.anton.subscreens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.butov.anton.Colors
import dev.butov.anton.myiconpack.AntonIcons
import dev.butov.anton.myiconpack.MessageAdd
import dev.butov.anton.myiconpack.Sms
import dev.butov.anton.myiconpack.Ss
import dev.butov.anton.uikit.CallButtonLight
import dev.butov.anton.uikit.FullStyle
import dev.butov.anton.uikit.SendMessageButton
import dev.butov.anton.uikit.SoftStyle

@Composable
fun ContactMe() {
    Row(Modifier.height(280.dp)) {
        LeftColumn(Modifier.weight(1f))

        Spacer(Modifier.weight(0.5f).defaultMinSize(minWidth = 20.dp))

        SendMessageBlock(Modifier.weight(3f).align(Alignment.Bottom))
    }
}

@Composable
private fun SendMessageBlock(modifier: Modifier) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(30.dp),
        ) {
            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                trailingIcon = { AntonIcons.Ss },
            )
            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                trailingIcon = { AntonIcons.Sms },
            )
        }
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().height(120.dp),
            value = message,
            onValueChange = { message = it },
            label = { Text("Message") },
            trailingIcon = { AntonIcons.MessageAdd },
        )
        SendMessageButton(Modifier.align(Alignment.End))
    }
}

@Composable
private fun LeftColumn(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
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
        Text(
            text = "I'm open to new connections, ideas, and opportunities that can help me grow. I'm also open to feedback.",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Light,
            color = Colors.primary.copy(alpha = 0.6f),
        )
        CallButtonLight(Modifier.align(Alignment.Start))
    }
}

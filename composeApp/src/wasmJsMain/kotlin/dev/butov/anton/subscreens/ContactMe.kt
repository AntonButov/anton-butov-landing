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
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    Box {
        Column(Modifier.align(Alignment.TopStart)) {
            Text(
                text =
                buildAnnotatedString {
                    FullStyle { append("Contact ") }
                    SoftStyle { append("Me") }
                },
                style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Medium),
            )
            Text(
                text = "I'm open to new connections, ideas, and opportunities that can help me grow. I'm also open to feedback."
            )
        }

        CallButtonLight(Modifier.align(Alignment.BottomStart))

        Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                trailingIcon = { AntonIcons.Ss }
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                trailingIcon = { AntonIcons.Sms }
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().height(120.dp),
                value = message,
                onValueChange = { message = it },
                label = { Text("Message") },
                trailingIcon = { AntonIcons.MessageAdd }
            )
            SendMessageButton(Modifier.align(Alignment.End))
        }
    }
}

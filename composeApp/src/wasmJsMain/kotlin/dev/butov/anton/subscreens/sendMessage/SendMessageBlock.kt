package dev.butov.anton.subscreens.sendMessage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.butov.anton.Colors
import dev.butov.anton.myiconpack.AntonIcons
import dev.butov.anton.myiconpack.Grid
import dev.butov.anton.myiconpack.Message
import dev.butov.anton.myiconpack.Sms
import dev.butov.anton.uikit.SendMessageButton

@Composable
fun SendMessageBlock(modifier: Modifier) {
    val viewModel = remember { SendMessageViewModel() }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        val textFieldColors =
            OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Colors.primary,
                unfocusedBorderColor = Colors.primary.copy(alpha = 0.05f),
                focusedLabelColor = Colors.primary,
                unfocusedLabelColor = Colors.primary.copy(alpha = 0.4f),
                cursorColor = Colors.primary,
                focusedContainerColor = Colors.surface,
                unfocusedContainerColor = Colors.surface,
            )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(30.dp),
        ) {
            OutlinedTextField(
                modifier = Modifier.weight(1f).height(70.dp),
                value = viewModel.name,
                onValueChange = viewModel::onNameChange,
                label = { Text("Name") },
                trailingIcon = {
                    Icon(
                        imageVector = AntonIcons.Grid,
                        contentDescription = null,
                        tint = Colors.primary,
                    )
                },
                colors = textFieldColors,
            )
            OutlinedTextField(
                modifier = Modifier.height(70.dp).weight(1f),
                value = viewModel.email,
                onValueChange = viewModel::onEmailChange,
                label = { Text("Email") },
                trailingIcon = {
                    Icon(
                        imageVector = AntonIcons.Sms,
                        contentDescription = null,
                        tint = Colors.primary,
                    )
                },
                colors = textFieldColors,
            )
        }
        Box(
            modifier = Modifier.fillMaxWidth().height(120.dp),
        ) {
            OutlinedTextField(
                modifier = Modifier.matchParentSize(),
                value = viewModel.message,
                onValueChange = viewModel::onMessageChange,
                label = { Text("Message") },
                trailingIcon = null,
                colors = textFieldColors,
            )
            Icon(
                modifier = Modifier.align(Alignment.TopEnd).padding(vertical = 23.dp, horizontal = 26.dp),
                imageVector = AntonIcons.Message,
                contentDescription = null,
            )
        }
        SendMessageButton(Modifier.align(Alignment.End))
    }
}

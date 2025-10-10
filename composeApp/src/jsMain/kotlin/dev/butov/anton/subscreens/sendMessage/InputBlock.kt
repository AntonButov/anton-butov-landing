package dev.butov.anton.subscreens.sendMessage

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.butov.anton.Colors
import dev.butov.anton.LocalIsMobile
import dev.butov.anton.myiconpack.AntonIcons
import dev.butov.anton.myiconpack.Grid
import dev.butov.anton.myiconpack.Message
import dev.butov.anton.myiconpack.Sms
import dev.butov.anton.uikit.SendMessageButton

@Composable
private fun TextFieldColors() =
    OutlinedTextFieldDefaults.colors(
        focusedBorderColor = Colors.primary,
        unfocusedBorderColor = Colors.primary.copy(alpha = 0.05f),
        focusedLabelColor = Colors.primary,
        unfocusedLabelColor = Colors.primary.copy(alpha = 0.4f),
        cursorColor = Colors.primary,
        focusedContainerColor = Colors.surface,
        unfocusedContainerColor = Colors.surface,
        focusedTextColor = Colors.primary,
        unfocusedTextColor = Colors.primary,
        errorTextColor = Colors.primary,
        errorBorderColor = Colors.red,
    )

@Composable
fun InputBlock(viewModel: SendMessageViewModel) {
    val isMobile = LocalIsMobile.current
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(if (isMobile) 7.dp else 20.dp),
    ) {
        if (isMobile) {
            OutlinedTextName(Modifier.fillMaxWidth(), viewModel)
            OutlinedTextEmail(Modifier.fillMaxWidth(), viewModel)
        } else {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(30.dp),
            ) {
                OutlinedTextName(Modifier.weight(1f), viewModel)
                OutlinedTextEmail(Modifier.weight(1f), viewModel)
            }
        }
        OutlinedTextMessage(viewModel)
        if (isMobile) {
            Spacer(Modifier.size(10.dp))
        }
        SendMessageButton(
            modifier = if (isMobile) Modifier.align(Alignment.CenterHorizontally) else Modifier.align(Alignment.End),
            onSend = viewModel::send,
        )
    }
}

@Composable
private fun OutlinedTextName(
    modifier: Modifier,
    viewModel: SendMessageViewModel,
) {
    OutlinedTextField(
        modifier = modifier.height(70.dp),
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
        colors = TextFieldColors(),
    )
}

@Composable
private fun OutlinedTextEmail(
    modifier: Modifier,
    viewModel: SendMessageViewModel,
) {
    OutlinedTextField(
        modifier = modifier.height(70.dp),
        value = viewModel.email,
        onValueChange = viewModel::onEmailChange,
        label = { Text("Email") },
        trailingIcon = {
            Icon(
                imageVector = AntonIcons.Sms,
                contentDescription = null,
                tint = if (viewModel.error == Error.Email) Colors.red else Colors.primary,
            )
        },
        colors = TextFieldColors(),
        isError = viewModel.error == Error.Email,
    )
}

@Composable
private fun OutlinedTextMessage(viewModel: SendMessageViewModel) {
    Box(
        modifier = Modifier.fillMaxWidth().height(120.dp),
    ) {
        OutlinedTextField(
            modifier = Modifier.matchParentSize(),
            value = viewModel.message,
            onValueChange = viewModel::onMessageChange,
            label = { Text("Message") },
            trailingIcon = null,
            colors = TextFieldColors(),
            isError = viewModel.error == Error.Message,
        )
        Icon(
            modifier = Modifier.align(Alignment.TopEnd).padding(vertical = 23.dp, horizontal = 26.dp),
            imageVector = AntonIcons.Message,
            contentDescription = null,
            tint = if (viewModel.error == Error.Message) Colors.red else Colors.primary,
        )
    }
}

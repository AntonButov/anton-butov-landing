package dev.butov.anton.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.butov.anton.subscreens.ContactMe
import dev.butov.anton.subscreens.Header
import dev.butov.anton.subscreens.MyProjects
import dev.butov.anton.subscreens.PhotoBlock
import dev.butov.anton.subscreens.Technologies
import dev.butov.anton.uikit.Message

@Composable
fun MainColumn() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(vertical = 50.dp),
    ) {
        Header()
        Spacer(modifier = Modifier.size(50.dp))
        PhotoBlock()
        Spacer(Modifier.size(60.dp))
        Technologies()
        Spacer(Modifier.size(150.dp))
        MyProjects()
        Message(Modifier.align(Alignment.CenterHorizontally))
        Spacer(Modifier.size(80.dp))
        ContactMe()
    }
}

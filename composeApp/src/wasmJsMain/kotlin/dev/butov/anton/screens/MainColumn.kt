package dev.butov.anton.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.butov.anton.PhotoBlock
import dev.butov.anton.Technologies
import dev.butov.anton.uikit.Header
import dev.butov.anton.uikit.Message
import dev.butov.anton.uikit.MyProjects

@Composable
fun MainColumn() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 81.dp, vertical = 50.dp),
    ) {
        Header()
        Spacer(modifier = Modifier.size(50.dp))
        PhotoBlock()
        Spacer(Modifier.size(60.dp))
        Technologies()
        Spacer(Modifier.size(150.dp))
        MyProjects()
        Message()
    }
}

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
import dev.butov.anton.tools.CenteredLayout
import dev.butov.anton.uikit.Message

@Composable
fun MainColumn() {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        CenteredLayout {
            Spacer(Modifier.size(50.dp))
        }
        CenteredLayout {
            Header()
        }
        CenteredLayout {
            Spacer(modifier = Modifier.size(50.dp))
        }
        CenteredLayout {
            PhotoBlock()
        }
        CenteredLayout {
            Spacer(Modifier.size(60.dp))
        }
        CenteredLayout {
            Technologies()
        }
        CenteredLayout {
            Spacer(Modifier.size(150.dp))
        }
        CenteredLayout {
            MyProjects()
        }
        CenteredLayout {
            Message(Modifier.align(Alignment.CenterHorizontally))
        }
        CenteredLayout {
            Spacer(Modifier.size(80.dp))
        }
        CenteredLayout {
            ContactMe()
        }
        CenteredLayout {
            Spacer(Modifier.size(50.dp))
        }
    }
}

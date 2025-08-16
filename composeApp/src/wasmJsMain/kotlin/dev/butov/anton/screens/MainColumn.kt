package dev.butov.anton.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.butov.anton.Colors
import dev.butov.anton.subscreens.*
import dev.butov.anton.subscreens.burger.MenuViewModel
import dev.butov.anton.tools.CenteredLayout
import dev.butov.anton.uikit.Message

@Composable
fun Home() {
    val menuViewModel = remember { MenuViewModel() }
    Column(modifier = Modifier.fillMaxWidth()) {
        CenteredLayout { Spacer(Modifier.size(50.dp)) }
        CenteredLayout { Header(menuViewModel) }
        CenteredLayout { Spacer(modifier = Modifier.size(50.dp)) }
        CenteredLayout {
            Box {
                PhotoBlock(menuViewModel)
                BackGroundRectangles()
            }
        }
        CenteredLayout { Spacer(Modifier.size(60.dp)) }
        CenteredLayout { Technologies() }
        CenteredLayout { Spacer(Modifier.size(150.dp)) }
    }
}

@Composable
fun Projects() {
    Column(modifier = Modifier.fillMaxWidth()) {
        CenteredLayout { MyProjects() }
    }
}

@Composable
fun Contacts() {
    Column(modifier = Modifier.fillMaxWidth()) {
        CenteredLayout { Spacer(Modifier.size(110.dp)) }
        CenteredLayout { Message(Modifier.align(Alignment.CenterHorizontally)) }
        CenteredLayout { Spacer(Modifier.size(130.dp)) }
        CenteredLayout { ContactMe() }
        CenteredLayout { Spacer(Modifier.size(110.dp)) }
        CenteredLayout(
            modifier = Modifier.background(Colors.surface),
            renderLines = false,
        ) {
            Footer()
        }
        CenteredLayout { Spacer(Modifier.size(50.dp)) }
        CenteredLayout { Spacer(Modifier.size(30.dp)) }
        CenteredLayout { Smirnov() }
        CenteredLayout { Spacer(Modifier.size(30.dp)) }
    }
}

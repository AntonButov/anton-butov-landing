package dev.butov.anton.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.butov.anton.Colors
import dev.butov.anton.LocalIsMobile
import dev.butov.anton.subscreens.*
import dev.butov.anton.subscreens.burger.MenuViewModel
import dev.butov.anton.tools.CenteredLayout

@Composable
fun Home(menuViewModel: MenuViewModel) {
    val isMobile = LocalIsMobile.current
    Column(modifier = Modifier.fillMaxWidth()) {
        CenteredLayout { Spacer(Modifier.size(50.dp)) }
        CenteredLayout { Header(menuViewModel) }
        CenteredLayout {
            Box {
                PhotoBlock(menuViewModel)
                if (isMobile) {
                    return@CenteredLayout
                }
                BackGroundRectangles()
            }
        }
        CenteredLayout { Spacer(Modifier.size(60.dp)) }
        CenteredLayout { Technologies() }
        CenteredLayout { if (isMobile) Spacer(Modifier.size(70.dp)) else Spacer(Modifier.size(150.dp)) }
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
    val isMobile = LocalIsMobile.current
    Column(modifier = Modifier.fillMaxWidth()) {
        CenteredLayout { Spacer(Modifier.size(if (isMobile) 36.dp else 130.dp)) }
        CenteredLayout { ContactMe() }
        CenteredLayout { Spacer(Modifier.size(if (isMobile) 90.dp else 110.dp)) }
        CenteredLayout(
            modifier = Modifier.background(Colors.surface),
            renderLines = false,
        ) {
            Footer()
        }
        CenteredLayout { Spacer(Modifier.size(30.dp)) }
        CenteredLayout { Smirnov() }
        CenteredLayout { Spacer(Modifier.size(30.dp)) }
    }
}

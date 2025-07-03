package dev.butov.anton.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import antonbutov.composeapp.generated.resources.Res
import antonbutov.composeapp.generated.resources.redBack
import dev.butov.anton.Colors
import dev.butov.anton.myiconpack.AntonIcons
import dev.butov.anton.myiconpack.RectangleHard
import dev.butov.anton.myiconpack.RectangleSoft
import org.jetbrains.compose.resources.painterResource

@Composable
fun BackGround() {
    Row(
        Modifier
            .height(3500.dp) // todo
            .fillMaxWidth()
            .background(Colors.background)
            .padding(horizontal = 80.dp),
    ) {
        val dividerColor = Colors.primary.copy(alpha = 0.1f)
        VerticalDivider(color = dividerColor)
        Box(Modifier.weight(1f)) {
            Icon(
                modifier = Modifier.align(Alignment.TopStart).padding(top = 200.dp),
                imageVector = AntonIcons.RectangleSoft,
                contentDescription = null,
            )
            Icon(
                modifier = Modifier.align(Alignment.Center).padding(top = 270.dp),
                imageVector = AntonIcons.RectangleHard,
                contentDescription = null,
            )
        }
        VerticalDivider(color = dividerColor)
        Box(Modifier.weight(1f)) {
            Icon(
                modifier = Modifier.align(Alignment.TopStart).padding(top = 400.dp, start = 150.dp),
                imageVector = AntonIcons.RectangleSoft,
                contentDescription = null,
            )
            Icon(
                modifier = Modifier.align(Alignment.TopEnd).padding(top = 200.dp, end = 100.dp),
                imageVector = AntonIcons.RectangleHard,
                contentDescription = null,
            )
        }
        VerticalDivider(color = dividerColor)
        Box(Modifier.weight(1f)) {
            Icon(
                modifier = Modifier.align(Alignment.TopStart).padding(start = 140.dp, top = 200.dp),
                imageVector = AntonIcons.RectangleSoft,
                contentDescription = null,
            )
        }
        VerticalDivider(color = dividerColor)
        Spacer(Modifier.weight(1f))
        VerticalDivider(color = dividerColor)
    }
    Image(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 80.dp, vertical = 350.dp),
        painter = painterResource(Res.drawable.redBack),
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
    )
}

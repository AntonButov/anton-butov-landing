package dev.butov.anton.uikit

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import antonbutov.composeapp.generated.resources.AntonButovMessage
import antonbutov.composeapp.generated.resources.Res
import antonbutov.composeapp.generated.resources.butov
import dev.butov.anton.myiconpack.AntonIcons
import dev.butov.anton.myiconpack.BrasesOn
import org.jetbrains.compose.resources.painterResource

@Composable
fun Message() {
    Row(Modifier.fillMaxWidth()) {
        Spacer(Modifier.weight(230f))
        Column(Modifier.weight(970f)) {
            Row(Modifier.height(140.dp).fillMaxWidth()) {
                Icon(
                    modifier = Modifier.align(Alignment.Bottom),
                    imageVector = AntonIcons.BrasesOn,
                    contentDescription = null,
                )
                Icon(
                    modifier = Modifier.align(Alignment.Top).size(100.dp),
                    painter = painterResource(Res.drawable.AntonButovMessage),
                    contentDescription = null,
                    tint = Color.Unspecified,
                )
            }
        }
        Spacer(Modifier.weight(230f))
    }
}

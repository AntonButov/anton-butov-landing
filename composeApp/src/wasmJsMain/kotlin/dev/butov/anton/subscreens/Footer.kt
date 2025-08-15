package dev.butov.anton.subscreens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.butov.anton.Colors
import dev.butov.anton.myiconpack.AntonIcons
import dev.butov.anton.myiconpack.Github
import dev.butov.anton.myiconpack.Ln
import dev.butov.anton.myiconpack.Teleg

@Composable
fun Footer() {
    Box(
        modifier = Modifier.height(150.dp).fillMaxWidth(),
    ) {
        AntonButov(Modifier.align(Alignment.CenterStart))
        Row(
            modifier = Modifier.align(Alignment.CenterEnd),
        ) {
            Button {
                Icon(
                    AntonIcons.Teleg,
                    contentDescription = "telega",
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button {
                Icon(
                    imageVector = AntonIcons.Github,
                    contentDescription = "github",
                )
            }
            Spacer(modifier = Modifier.size(10.dp))
            Button {
                Icon(
                    imageVector = AntonIcons.Ln,
                    contentDescription = "linkedin",
                )
            }
            Spacer(modifier = Modifier.size(10.dp))
            Button {
                Text(
                    text = "mail@antonbutov.com",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Normal),
                )
            }
        }
    }
}

@Composable
private fun Button(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Box(
        modifier =
            modifier
                .clip(MaterialTheme.shapes.small)
                .border(
                    width = 1.dp,
                    color = Colors.primary.copy(0.08f),
                    shape = MaterialTheme.shapes.small,
                ).height(70.dp).padding(horizontal = 25.dp),
        contentAlignment = Alignment.Center,
    ) {
        content()
    }
}

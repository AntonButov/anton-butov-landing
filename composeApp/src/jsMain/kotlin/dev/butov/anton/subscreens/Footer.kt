package dev.butov.anton.subscreens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.onClick
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.butov.anton.AppVersion
import dev.butov.anton.Colors
import dev.butov.anton.LocalIsMobile
import dev.butov.anton.myiconpack.AntonIcons
import dev.butov.anton.myiconpack.Github
import dev.butov.anton.myiconpack.Ln
import dev.butov.anton.myiconpack.Teleg
import kotlinx.browser.window

@Composable
fun Footer() {
    val isMobile = LocalIsMobile.current
    if (isMobile) {
        Row {
            Spacer(Modifier.weight(1f))
            Column(
                modifier = Modifier.padding(vertical = 50.dp).width(IntrinsicSize.Min),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                AntonButov()
                Spacer(Modifier.size(30.dp))
                Messagers()
                Spacer(Modifier.size(10.dp))
                EMail(Modifier.fillMaxWidth())
                Spacer(Modifier.size(15.dp))
                AppVersionInfo()
            }
            Spacer(Modifier.weight(1f))
        }
    } else {
        Box(
            modifier = Modifier.height(150.dp).fillMaxWidth(),
        ) {
            AntonButov(Modifier.align(Alignment.CenterStart))
            Row(
                modifier = Modifier.align(Alignment.CenterEnd),
            ) {
                Messagers()
                Spacer(modifier = Modifier.size(10.dp))
                EMail()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun EMail(modifier: Modifier = Modifier) {
    Button(
        modifier =
            modifier.onClick(onClick = {
                window.open("mailto:mail@antonbutov.com", "_blank")
            }),
    ) {
        Text(
            text = "mail@antonbutov.com",
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Normal),
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun Messagers() {
    Row {
        Button(
            modifier =
                Modifier.onClick(onClick = {
                    window.open("https://t.me/antonbutov", "_blank")
                }),
        ) {
            Icon(
                AntonIcons.Teleg,
                contentDescription = "telega",
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Button(
            modifier =
                Modifier.onClick(onClick = {
                    window.open("https://github.com/AntonButov", "_blank")
                }),
        ) {
            Icon(
                imageVector = AntonIcons.Github,
                contentDescription = "github",
            )
        }
        Spacer(modifier = Modifier.size(10.dp))
        Button(
            modifier =
                Modifier.onClick(onClick = {
                    window.open("https://www.linkedin.com/in/antonbutov", "_blank")
                }),
        ) {
            Icon(
                imageVector = AntonIcons.Ln,
                contentDescription = "linkedin",
            )
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

@Composable
private fun AppVersionInfo() {
    Text(
        text = AppVersion.getFullVersion(),
        style =
            MaterialTheme.typography.labelSmall.copy(
                fontWeight = FontWeight.Normal,
                fontSize = 10.sp,
            ),
        color = Colors.primary.copy(alpha = 0.4f),
        textAlign = TextAlign.Center,
    )
}

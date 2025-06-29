package dev.butov.anton

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.AnnotatedString.Builder
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import antonbutov.composeapp.generated.resources.Res
import antonbutov.composeapp.generated.resources.butov
import antonbutov.composeapp.generated.resources.redBack
import dev.butov.anton.myiconpack.*
import org.jetbrains.compose.resources.painterResource


@Composable
fun App() {
    MaterialTheme {
        CompositionLocalProvider(
            LocalTextStyle provides LocalTextStyle.current.copy(
                fontFamily = InterFonts(),
            ),
            LocalContentColor provides Colors.primary,
        ) {
            var showContent by remember { mutableStateOf(false) }
            val scrollState = rememberLazyListState()
            Box(modifier = Modifier.fillMaxSize()) {
                BackGround(scrollState)
                MainColumn()
                VerticalScrollbar(
                    adapter = rememberScrollbarAdapter(scrollState),
                    modifier = Modifier.fillMaxHeight().align(Alignment.CenterEnd),
                )
            }
        }
    }
}

@Composable
fun MainColumn() {
    Column(Modifier.fillMaxSize().padding(horizontal = 81.dp, vertical = 50.dp)) {
        Header()
        Spacer(modifier = Modifier.size(50.dp))
        PhotoBlock()
    }
}

@Composable
fun PhotoBlock() {
    Box(modifier = Modifier.fillMaxSize()) {
        Im(Modifier.align(Alignment.BottomStart))
        Icon(
            painter = painterResource(Res.drawable.butov),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterEnd),
        )
    }
}

@Composable
fun Im(modifier: Modifier) {
    Column(modifier = modifier) {
        val firstText =
            buildAnnotatedString {
                SoftStyle {
                    append("I'm ")
                }
                FullStyle {
                    append("Anton Butov\n")
                }
                SoftStyle {
                    append("and I'm a ")
                }
                FullStyle {
                    append("Senior Android Developer")
                }
            }
        Text(
            text = firstText,
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Medium),
        )
        Spacer(Modifier.size(24.dp))
        val secondText = "Nice to meet you."
        Text(
            text = secondText,
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold),
            color = Colors.primary.copy(alpha = 0.6f),
        )
    }
}

private val softStyle = SpanStyle(
    color = Colors.primary.copy(alpha = 0.6f),
)
private val fullStyle = SpanStyle(
    color = Colors.primary,
)

private fun Builder.SoftStyle(block: Builder.() -> Unit) =
    withStyle(softStyle, block)

private fun Builder.FullStyle(block: Builder.() -> Unit) =
    withStyle(fullStyle, block)

@Composable
fun Header() {
    Box(
        Modifier
            .height(50.dp)
            .fillMaxWidth(),
    ) {
        Hamburger()
        Arrows()
        AntonButov()
        CallButton()
    }
}

@Composable
fun Hamburger() {
    Icon(
        imageVector = AntonIcons.Gamburger,
        contentDescription = "Gamburger",
    )
}

@Composable
fun BoxScope.Arrows() {
    Row(
        modifier = Modifier.align(Alignment.Center),
    ) {
        Arrow()
        Arrow()
    }
}

@Composable
private fun Arrow() {
    Icon(
        imageVector = AntonIcons.Arrow,
        contentDescription = "Arrow",
    )
}

@Composable
fun BoxScope.AntonButov() {
    Icon(
        modifier = Modifier.align(Alignment.Center),
        imageVector = AntonIcons.AntonButov,
        tint = Colors.primary,
        contentDescription = "AntonButov",
    )
}

@Composable
fun BoxScope.CallButton() {
    Box(
        modifier =
        Modifier
            .align(Alignment.CenterEnd)
            .width(160.dp)
            .fillMaxHeight()
            .clip(MaterialTheme.shapes.small)
            .background(Colors.primary.copy(alpha = 0.1f))
            .border(1.dp, Colors.primary.copy(alpha = 0.2f), MaterialTheme.shapes.small)
            .padding(horizontal = 7.dp, vertical = 6.dp),
    ) {
        Row(
            modifier =
            Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Assign a call",
                color = Colors.primary,
                style = MaterialTheme.typography.bodyMedium,
            )
            Icon(
                imageVector = AntonIcons.Call,
                contentDescription = "Phone Icon",
                tint = Colors.primary,
            )
        }
    }
}

@Composable
fun BackGround(scrollState: LazyListState) {
    LazyColumn(
        state = scrollState,
    ) {
        item {
            Box(
                Modifier
                    .background(Colors.background)
                    .height(3500.dp)
                    .fillMaxWidth(),
            ) {
                Row(
                    Modifier
                        .fillMaxSize()
                        .padding(horizontal = 80.dp),
                ) {
                    val dividerColor = Colors.primary.copy(alpha = 0.1f)
                    VerticalDivider(color = dividerColor)
                    Box(Modifier.weight(1f)) {
                        Icon(
                            modifier = Modifier.align(Alignment.TopStart).padding(top = 200.dp),
                            imageVector = AntonIcons.RectangleSoft,
                            contentDescription = null,
                            tint = Colors.primary,
                        )
                        Icon(
                            modifier = Modifier.align(Alignment.Center).padding(top = 270.dp),
                            imageVector = AntonIcons.RectangleHard,
                            contentDescription = null,
                            tint = Colors.primary,
                        )
                    }
                    VerticalDivider(color = dividerColor)
                    Box(Modifier.weight(1f)) {
                        Icon(
                            modifier = Modifier.align(Alignment.TopStart).padding(top = 400.dp, start = 150.dp),
                            imageVector = AntonIcons.RectangleSoft,
                            contentDescription = null,
                            tint = Colors.primary,
                        )
                        Icon(
                            modifier = Modifier.align(Alignment.TopEnd).padding(top = 200.dp, end = 100.dp),
                            imageVector = AntonIcons.RectangleHard,
                            contentDescription = null,
                            tint = Colors.primary,
                        )
                    }
                    VerticalDivider(color = dividerColor)
                    Box(Modifier.weight(1f)) {
                        Icon(
                            modifier = Modifier.align(Alignment.TopStart).padding(start = 140.dp, top = 200.dp),
                            imageVector = AntonIcons.RectangleSoft,
                            contentDescription = null,
                            tint = Colors.primary,
                        )
                    }
                    VerticalDivider(color = dividerColor)
                    Spacer(Modifier.weight(1f))
                    VerticalDivider(color = dividerColor)
                }
                Image(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 80.dp, vertical = 550.dp),
                    painter = painterResource(Res.drawable.redBack),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                )
            }
        }
    }
}

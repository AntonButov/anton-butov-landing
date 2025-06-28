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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import antonbutov.composeapp.generated.resources.*
import antonbutov.composeapp.generated.resources.Inter_28pt_Regular
import antonbutov.composeapp.generated.resources.Res
import antonbutov.composeapp.generated.resources.call
import dev.butov.anton.myiconpack.AntonButov
import dev.butov.anton.myiconpack.Arrow
import dev.butov.anton.myiconpack.Call
import dev.butov.anton.myiconpack.RedBack
import org.jetbrains.compose.resources.painterResource

import org.jetbrains.compose.resources.Font

@Composable
fun App() {
    val antonButovPainter = painterResource(Res.drawable.antonButov)

    MaterialTheme {
        CompositionLocalProvider(
            LocalTextStyle provides LocalTextStyle.current.copy(fontFamily = InterFonts())
        ) {
            var showContent by remember { mutableStateOf(false) }
            val scrollState = rememberLazyListState()
            Box(modifier = Modifier.fillMaxSize()) {
                /*
            LazyColumn(
                modifier = Modifier.background(color = Color.LightGray).fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                item {
                    Button(onClick = { showContent = !showContent }) {
                        Text("Click me!")
                    }
                    Button(onClick = { showContent = !showContent }) {
                        Text("Click me!")
                    }
                    AnimatedVisibility(showContent) {
                        val greeting = remember { Greeting().greet() }
                        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(painterResource(Res.drawable.compose_multiplatform), null)
                            Text("Compose: $greeting")
                        }
                    }
                }
            }

             */

                BackGround(scrollState)

                MainColumn(antonButovPainter)
                VerticalScrollbar(
                        adapter = rememberScrollbarAdapter(scrollState),
                        modifier = Modifier.fillMaxHeight().align(Alignment.CenterEnd)
                )
            }
        }
    }
}

@Composable
fun MainColumn(antonButovPainter: Painter) {
    Column(Modifier.fillMaxSize().padding(horizontal = 81.dp, vertical = 50.dp)) {
        Header(antonButovPainter)
    }
}

@Composable
fun Header(antonButovPainter: Painter) {
    Box(
        Modifier
            .height(50.dp)
            .fillMaxWidth()
    ) {
        Arrows()
        AntonButov(antonButovPainter)
        CallButton()
    }
}

@Composable
fun BoxScope.Arrows() {
    Row(
        modifier = Modifier.align(Alignment.Center)
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
        tint = Colors.primary,
    )
}

@Composable
fun BoxScope.AntonButov(antonButovPainter: Painter) {
        Icon(
            modifier = Modifier.align(Alignment.Center),
            imageVector = AntonIcons.AntonButov,
            tint = Colors.primary,
            contentDescription = "AntonButov"
        )
}

@Composable
fun BoxScope.CallButton() {
        Box(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .width(160.dp)
                .fillMaxHeight()
                .clip(MaterialTheme.shapes.small)
                .background(Colors.primary.copy(alpha = 0.1f))
                .border(1.dp, Colors.primary.copy(alpha = 0.2f), MaterialTheme.shapes.small)
                .padding(horizontal = 7.dp, vertical = 6.dp)
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Assign a call",
                    color = Colors.primary,
                    style = MaterialTheme.typography.bodyMedium,
                )
                Icon(
                    imageVector = AntonIcons.Call,
                    contentDescription = "Phone Icon",
                    tint = Colors.primary
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
                    .fillMaxWidth()
            ) {
                Row(
                    Modifier
                        .fillMaxSize()
                        .padding(horizontal = 80.dp)
                ) {
                    val dividerColor = Colors.primary.copy(alpha = 0.1f)
                    VerticalDivider(color = dividerColor)
                    Spacer(Modifier.weight(1f))
                    VerticalDivider(color = dividerColor)
                    Spacer(Modifier.weight(1f))
                    VerticalDivider(color = dividerColor)
                    Spacer(Modifier.weight(1f))
                    VerticalDivider(color = dividerColor)
                    Spacer(Modifier.weight(1f))
                    VerticalDivider(color = dividerColor)
                }
                Image(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 80.dp, vertical = 550.dp),
                    imageVector = AntonIcons.RedBack, contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
            }
        }
    }
}


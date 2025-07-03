package dev.butov.anton

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import antonbutov.composeapp.generated.resources.Res
import antonbutov.composeapp.generated.resources.butov
import antonbutov.composeapp.generated.resources.redBack
import dev.butov.anton.myiconpack.*
import dev.butov.anton.screens.BackGround
import dev.butov.anton.screens.MainColumn
import dev.butov.anton.uikit.*
import org.jetbrains.compose.resources.painterResource

@Composable
fun App() {
    MaterialTheme {
        CompositionLocalProvider(
            LocalTextStyle provides
                LocalTextStyle.current.copy(
                    fontFamily = InterFonts(),
                ),
            LocalContentColor provides Colors.primary,
        ) {
            var showContent by remember { mutableStateOf(false) }
            val scrollState = rememberLazyListState()
            Box(modifier = Modifier.fillMaxSize()) {
                LazyColumn(state = scrollState) {
                    item {
                        Box {
                            BackGround()
                            MainColumn()
                        }
                    }
                }
                VerticalScrollbar(
                    adapter = rememberScrollbarAdapter(scrollState),
                    modifier = Modifier.fillMaxHeight().align(Alignment.CenterEnd),
                )
            }
        }
    }
}

@Composable
fun Technologies() {
    FlowRow(
        modifier =
            Modifier
                .clip(MaterialTheme.shapes.medium)
                .background(Colors.background.copy(alpha = 0.45f))
                .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(7.dp),
        verticalArrangement = Arrangement.spacedBy(7.dp),
    ) {
        TechnologyHeader()
        TechnologyKotlin()
        TechnologyJava()
        TechnologyCompose()
        TechnologyDagger()
        TechnologyCleanArchitecture()
        TechnologyTDD()
        TechnologyKMP()
    }
}

@Composable
fun PhotoBlock() {
    Box(modifier = Modifier.height(550.dp).fillMaxWidth()) {
        Im(Modifier.align(Alignment.BottomStart))
        Icon(
            painter = painterResource(Res.drawable.butov),
            contentDescription = null,
            modifier =
                Modifier
                    .align(Alignment.BottomEnd),
            tint = Color.Unspecified,
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
        Spacer(Modifier.size(24.dp))
        CallButtonLight(Modifier.height(50.dp))
    }
}

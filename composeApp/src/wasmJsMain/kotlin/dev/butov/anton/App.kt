package dev.butov.anton

import androidx.compose.foundation.*
import androidx.compose.foundation.LocalScrollbarStyle
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import antonbutov.composeapp.generated.resources.butov
import dev.butov.anton.myiconpack.*
import dev.butov.anton.screens.BackGround
import dev.butov.anton.screens.MainColumn
import dev.butov.anton.tools.CenteredLayout
import dev.butov.anton.uikit.*

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
                        CenteredLayout {
                            Box {
                                BackGround()
                                MainColumn()
                            }
                        }
                    }
                }
                val scrollbarStyle =
                    LocalScrollbarStyle.current.copy(
                        hoverColor = Colors.red,
                        unhoverColor = Colors.red,
                    )
                VerticalScrollbar(
                    adapter = rememberScrollbarAdapter(scrollState),
                    modifier = Modifier.fillMaxHeight().align(Alignment.CenterEnd),
                    style = scrollbarStyle,
                )
            }
        }
    }
}

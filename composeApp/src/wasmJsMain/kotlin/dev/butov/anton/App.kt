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
import androidx.compose.ui.layout.ContentScale
import antonbutov.composeapp.generated.resources.Res
import antonbutov.composeapp.generated.resources.butov
import antonbutov.composeapp.generated.resources.redBack
import dev.butov.anton.myiconpack.*
import dev.butov.anton.screens.Contacts
import dev.butov.anton.screens.Home
import dev.butov.anton.screens.Projects
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
            val scrollState = rememberLazyListState()
            Box(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .background(Colors.background),
            ) {
                Image(
                    modifier =
                        Modifier
                            .fillMaxWidth(),
                    painter = painterResource(Res.drawable.redBack),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                )
                LazyColumn(state = scrollState) {
                    item {
                        Box {
                            Home()
                        }
                    }
                    item {
                        Projects()
                    }
                    item {
                        Contacts()
                    }
                }
                val scrollbarStyle =
                    LocalScrollbarStyle.current.copy(
                        hoverColor = Colors.red,
                        unhoverColor = Colors.red,
                    )

                VerticalScrollbar(
                    modifier = Modifier.fillMaxHeight().align(Alignment.CenterEnd),
                    adapter = rememberScrollbarAdapter(scrollState),
                    style = scrollbarStyle,
                )
            }
        }
    }
}

package dev.butov.anton

import androidx.compose.foundation.*
import androidx.compose.foundation.LocalScrollbarStyle
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.butov.anton.screens.Contacts
import dev.butov.anton.screens.Home
import dev.butov.anton.screens.Projects
import dev.butov.anton.subscreens.Redback
import dev.butov.anton.subscreens.burger.MenuViewModel
import dev.butov.anton.uikit.Message

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
            val menuViewModel = remember { MenuViewModel() }

            val technologiesDp = 600.dp vs 700.dp
            val projectsDp = 1100.dp vs 1000.dp
            val contactDp = 3000.dp vs 2400.dp

            LaunchedEffect(menuViewModel.scrollRequests) {
                menuViewModel.scrollRequests.let { index ->
                    when (index) { // https://github.com/AntonButov/anton-butov-landing/issues/39
                        0 -> scrollState.animateScrollBy(0f) // Home - остаемся в начале
                        1 -> scrollState.animateScrollBy(technologiesDp.value) // Technologies - скролл к секции технологий
                        2 -> scrollState.animateScrollBy(projectsDp.value) // Projects - скролл к проектам
                        3 -> scrollState.animateScrollBy(contactDp.value) // Contact - скролл к контактам
                        else -> error("Index not found.")
                    }
                }
            }

            Box(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .background(Colors.background),
            ) {
                LazyColumn(state = scrollState) {
                    item {
                        Box {
                            Redback()
                            Column {
                                Box {
                                    Home(menuViewModel)
                                }
                                Projects()
                                Message()
                                Contacts()
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
                    modifier = Modifier.fillMaxHeight().align(Alignment.CenterEnd),
                    adapter = rememberScrollbarAdapter(scrollState),
                    style = scrollbarStyle,
                )
            }
        }
    }
}

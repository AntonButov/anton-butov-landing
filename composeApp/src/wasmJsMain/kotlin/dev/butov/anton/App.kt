package dev.butov.anton

import androidx.compose.animation.core.*
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import dev.butov.anton.screens.Contacts
import dev.butov.anton.screens.Home
import dev.butov.anton.screens.Projects
import dev.butov.anton.subscreens.Redback
import dev.butov.anton.subscreens.burger.MenuViewModel
import dev.butov.anton.uikit.Message
import kotlinx.browser.document

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
            
            // Состояние готовности контента
            var isContentReady by remember { mutableStateOf(false) }
            
            // Анимация появления контента
            val contentAlpha by animateFloatAsState(
                targetValue = if (isContentReady) 1f else 0f,
                animationSpec = tween(800, easing = EaseInOut),
                label = "content_alpha"
            )
            
            // Дополнительная анимация для плавного появления
            val contentScale by animateFloatAsState(
                targetValue = if (isContentReady) 1f else 0.95f,
                animationSpec = tween(800, easing = EaseInOut),
                label = "content_scale"
            )

            LaunchedEffect(menuViewModel.scrollRequests) {
                menuViewModel.scrollRequests.let { index ->
                    when (index) {
                        0 -> scrollState.animateScrollBy(0f) // Home - остаемся в начале
                        1 -> scrollState.animateScrollBy(700.dp.value) // Technologies - скролл к секции технологий
                        2 -> scrollState.animateScrollBy(1000.dp.value) // Projects - скролл к проектам
                        3 -> scrollState.animateScrollBy(2400.dp.value) // Contact - скролл к контактам
                        else -> error("Index not found.")
                    }
                }
            }
            
            // Инициализация контента
            LaunchedEffect(Unit) {
                // Небольшая задержка для плавного появления
                kotlinx.coroutines.delay(100)
                isContentReady = true
            }

            Box(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .background(Colors.background),
            ) {
                // Основной контент с анимацией
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(contentAlpha)
                        .scale(contentScale)
                ) {
                    LazyColumn(
                        state = scrollState,
                        // Optimize performance with lazy loading
                        contentPadding = PaddingValues(0.dp),
                    ) {
                        item {
                            Box {
                                Redback()
                                Column {
                                    Box {
                                        Home(menuViewModel)
                                    }
                                    // Lazy load non-critical sections
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
}

package dev.butov.anton

import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.events.Event

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    document.body?.style?.backgroundColor = "#0B0B0B"
    ComposeViewport(document.body!!) {
        var windowSize by remember { mutableStateOf(IntSize(window.innerWidth, window.innerHeight)) }
        WindowResizeListener { width, height ->
            windowSize = IntSize(width, height)
        }
        val isMobile = windowSize.width <= 768
        App(isMobile)
    }
}

@Composable
fun WindowResizeListener(onResize: (Int, Int) -> Unit) {
    DisposableEffect(Unit) {
        val listener: (Event) -> Unit = {
            onResize(window.innerWidth, window.innerHeight)
        }
        window.addEventListener("resize", listener)
        onDispose {
            window.removeEventListener("resize", listener)
        }
    }
}

package dev.butov.anton

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.Text
import org.w3c.dom.events.Event

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {
        var windowSize = remember { mutableStateOf(IntSize(0, 0)) }.value
        WindowResizeListener { width, height ->
            windowSize = IntSize(width, height)
        }
        App()
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

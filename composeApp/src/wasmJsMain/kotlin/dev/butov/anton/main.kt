package dev.butov.anton

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import kotlinx.browser.window

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    fun render() {
        ComposeViewport(document.body!!) {
            App()
        }
    }
    render()
    window.onresize = { render() }
}

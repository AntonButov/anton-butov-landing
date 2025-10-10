package dev.butov.anton

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.FontFamily

/**
 * Returns a cached instance of the Inter [FontFamily].
 * The fonts are requested only once and reused on subsequent recompositions.
 */
@Composable
fun rememberInterFontFamily(): FontFamily {
    // For now, use system fonts as Inter fonts may not load properly in WebAssembly
    return remember { FontFamily.Default }
}

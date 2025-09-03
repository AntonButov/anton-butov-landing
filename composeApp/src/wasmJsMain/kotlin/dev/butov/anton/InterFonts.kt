package dev.butov.anton

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import antonbutov.composeapp.generated.resources.Inter_28pt_Light
import antonbutov.composeapp.generated.resources.Inter_28pt_Medium
import antonbutov.composeapp.generated.resources.Inter_28pt_Regular
import antonbutov.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

/**
 * Returns a cached instance of the Inter [FontFamily].
 * The fonts are requested only once and reused on subsequent recompositions.
 */
@Composable
fun rememberInterFontFamily(): FontFamily {
    val regular = Font(resource = Res.font.Inter_28pt_Regular, weight = FontWeight.Normal)
    val medium = Font(resource = Res.font.Inter_28pt_Medium, weight = FontWeight.Medium)
    val light = Font(resource = Res.font.Inter_28pt_Light, weight = FontWeight.Light)
    return remember { FontFamily(regular, medium, light) }
}

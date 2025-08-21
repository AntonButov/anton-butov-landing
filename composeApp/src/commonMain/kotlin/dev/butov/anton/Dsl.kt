package dev.butov.anton

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp

@Composable
infix fun Dp.vs(smartDp: Dp): Dp {
    val isMobile = LocalIsMobile.current
    return if (isMobile) this else smartDp
}

package dev.butov.anton.subscreens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Footer() {
    Box(Modifier.height(150.dp)) {
        AntonButov(Modifier.align(Alignment.CenterStart))
    }
}

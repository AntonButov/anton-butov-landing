package dev.butov.anton.tools

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.butov.anton.Colors

@Composable
fun CenteredLayout(
    maxWith: Dp = 1300.dp,
    content: @Composable () -> Unit,
) {
    Box(
        modifier =
            Modifier
                .fillMaxWidth()
                .background(Colors.background),
        contentAlignment = Alignment.TopCenter,
    ) {
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            val maxContentWidth = maxWith
            val horizontalPadding =
                if (maxWidth > maxContentWidth) {
                    (maxWidth - maxContentWidth) / 2
                } else {
                    80.dp
                }

            Box(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = horizontalPadding),
            ) {
                content()
            }
        }
    }
}

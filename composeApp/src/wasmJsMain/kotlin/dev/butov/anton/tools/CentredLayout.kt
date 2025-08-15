package dev.butov.anton.tools

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.butov.anton.screens.BackLines

@Composable
fun CenteredLayout(
    maxWith: Dp = 1400.dp,
    content: @Composable () -> Unit,
) {
    Box(
        modifier =
            Modifier
                .fillMaxWidth(),
        contentAlignment = Alignment.TopCenter,
    ) {
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            val horizontalPadding =
                if (maxWidth > maxWith) {
                    (maxWidth - maxWith) / 2
                } else {
                    80.dp
                }

            Box(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = horizontalPadding),
            ) {
                BackLines()
                content()
            }
        }
    }
}

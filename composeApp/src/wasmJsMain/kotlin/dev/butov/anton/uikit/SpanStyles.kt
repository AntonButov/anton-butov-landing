package dev.butov.anton.uikit

import androidx.compose.ui.text.AnnotatedString.Builder
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.withStyle
import dev.butov.anton.Colors

private val softStyle = SpanStyle(
    color = Colors.primary.copy(alpha = 0.6f),
)
private val fullStyle = SpanStyle(
    color = Colors.primary,
)

fun Builder.SoftStyle(block: Builder.() -> Unit) =
    withStyle(softStyle, block)

fun Builder.FullStyle(block: Builder.() -> Unit) =
    withStyle(fullStyle, block)
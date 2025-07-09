package dev.butov.anton.myiconpack

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

val AntonIcons.Ok: ImageVector by lazy {
    Builder(
        name = "Ok",
        defaultWidth = 174.0.dp,
        defaultHeight = 126.0.dp,
        viewportWidth =
        174.0f,
        viewportHeight = 126.0f,
    ).apply {
        path(
            fill = SolidColor(Color(0x00000000)),
            stroke = SolidColor(Color(0xFFE20100)),
            strokeLineWidth = 26.0f,
            strokeLineCap = Round,
            strokeLineJoin =
                StrokeJoin.Companion.Round,
            strokeLineMiter = 4.0f,
            pathFillType = NonZero,
        ) {
            moveTo(13.0f, 65.0f)
            lineTo(61.0f, 113.0f)
            lineTo(161.0f, 13.0f)
        }
    }
        .build()
}

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = AntonIcons.Ok, contentDescription = "")
    }
}

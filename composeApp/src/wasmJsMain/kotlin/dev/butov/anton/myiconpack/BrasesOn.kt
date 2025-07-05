package dev.butov.anton.myiconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val AntonIcons.BrasesOn: ImageVector by lazy {
    Builder(
        name = "Braseson",
        defaultWidth = 101.0.dp,
        defaultHeight = 89.0.dp,
        viewportWidth = 101.0f,
        viewportHeight = 89.0f,
    ).apply {
        path(
            fill = SolidColor(Color(0xFFffffff)), stroke = null, fillAlpha = 0.1f,
            strokeAlpha =
            0.1f,
            strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
            strokeLineMiter = 4.0f, pathFillType = NonZero,
        ) {
            moveTo(0.0f, 35.443f)
            lineTo(49.607f, 0.0f)
            verticalLineTo(22.841f)
            lineTo(18.851f, 44.303f)
            lineTo(49.806f, 65.372f)
            verticalLineTo(89.0f)
            lineTo(0.0f, 53.557f)
            verticalLineTo(35.443f)
            close()
            moveTo(51.194f, 35.443f)
            lineTo(100.802f, 0.0f)
            verticalLineTo(22.841f)
            lineTo(70.045f, 44.303f)
            lineTo(101.0f, 65.372f)
            verticalLineTo(89.0f)
            lineTo(51.194f, 53.557f)
            verticalLineTo(35.443f)
            close()
        }
    }
        .build()
}

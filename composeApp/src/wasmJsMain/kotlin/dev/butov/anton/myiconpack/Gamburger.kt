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

val AntonIcons.Gamburger: ImageVector by lazy {
    Builder(
        name = "Group 5",
        defaultWidth = 46.0.dp,
        defaultHeight = 46.0.dp,
        viewportWidth = 46.0f,
        viewportHeight = 46.0f,
    ).apply {
        path(
            fill = SolidColor(Color(0xFFffffff)),
            stroke = null,
            fillAlpha = 0.1f,
            strokeLineWidth = 0.0f,
            strokeLineCap = Butt,
            strokeLineJoin = Miter,
            strokeLineMiter = 4.0f,
            pathFillType = NonZero,
        ) {
            moveTo(0.0f, 5.0f)
            curveTo(0.0f, 2.2386f, 2.2386f, 0.0f, 5.0f, 0.0f)
            horizontalLineTo(41.0f)
            curveTo(43.7614f, 0.0f, 46.0f, 2.2386f, 46.0f, 5.0f)
            verticalLineTo(41.0f)
            curveTo(46.0f, 43.7614f, 43.7614f, 46.0f, 41.0f, 46.0f)
            horizontalLineTo(5.0f)
            curveTo(2.2386f, 46.0f, 0.0f, 43.7614f, 0.0f, 41.0f)
            verticalLineTo(5.0f)
            close()
        }
        path(
            fill = SolidColor(Color(0x00000000)),
            stroke = SolidColor(Color(0xFFffffff)),
            strokeAlpha = 0.2f,
            strokeLineWidth = 1.0f,
            strokeLineCap = Butt,
            strokeLineJoin =
            Miter,
            strokeLineMiter = 4.0f,
            pathFillType = NonZero,
        ) {
            moveTo(5.0f, 0.5f)
            horizontalLineTo(41.0f)
            curveTo(43.4853f, 0.5f, 45.5f, 2.5147f, 45.5f, 5.0f)
            verticalLineTo(41.0f)
            curveTo(45.5f, 43.4853f, 43.4853f, 45.5f, 41.0f, 45.5f)
            horizontalLineTo(5.0f)
            curveTo(2.5147f, 45.5f, 0.5f, 43.4853f, 0.5f, 41.0f)
            verticalLineTo(5.0f)
            curveTo(0.5f, 2.5147f, 2.5147f, 0.5f, 5.0f, 0.5f)
            close()
        }
        path(
            fill = SolidColor(Color(0xFFffffff)),
            stroke = null,
            strokeLineWidth = 0.0f,
            strokeLineCap = Butt,
            strokeLineJoin = Miter,
            strokeLineMiter = 4.0f,
            pathFillType = NonZero,
        ) {
            moveTo(10.0f, 19.0f)
            lineTo(36.0f, 19.0f)
            arcTo(1.0f, 1.0f, 0.0f, false, true, 37.0f, 20.0f)
            lineTo(37.0f, 20.0f)
            arcTo(1.0f, 1.0f, 0.0f, false, true, 36.0f, 21.0f)
            lineTo(10.0f, 21.0f)
            arcTo(1.0f, 1.0f, 0.0f, false, true, 9.0f, 20.0f)
            lineTo(9.0f, 20.0f)
            arcTo(1.0f, 1.0f, 0.0f, false, true, 10.0f, 19.0f)
            close()
        }
        path(
            fill = SolidColor(Color(0xFFffffff)),
            stroke = null,
            strokeLineWidth = 0.0f,
            strokeLineCap = Butt,
            strokeLineJoin = Miter,
            strokeLineMiter = 4.0f,
            pathFillType = NonZero,
        ) {
            moveTo(10.0f, 25.0f)
            lineTo(36.0f, 25.0f)
            arcTo(1.0f, 1.0f, 0.0f, false, true, 37.0f, 26.0f)
            lineTo(37.0f, 26.0f)
            arcTo(1.0f, 1.0f, 0.0f, false, true, 36.0f, 27.0f)
            lineTo(10.0f, 27.0f)
            arcTo(1.0f, 1.0f, 0.0f, false, true, 9.0f, 26.0f)
            lineTo(9.0f, 26.0f)
            arcTo(1.0f, 1.0f, 0.0f, false, true, 10.0f, 25.0f)
            close()
        }
    }
        .build()
}

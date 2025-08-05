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

val AntonIcons.Grid: ImageVector by lazy {
    Builder(
        name = "Grid",
        defaultWidth = 24.0.dp,
        defaultHeight = 24.0.dp,
        viewportWidth = 24.0f,
        viewportHeight = 24.0f,
    ).apply {
        path(
            fill = SolidColor(Color(0xFFffffff)),
            stroke = null,
            strokeLineWidth = 0.0f,
            strokeLineCap = Butt,
            strokeLineJoin = Miter,
            strokeLineMiter = 4.0f,
            pathFillType = NonZero,
        ) {
            moveTo(7.9998f, 21.75f)
            curveTo(7.9698f, 21.75f, 7.9398f, 21.75f, 7.9198f, 21.75f)
            curveTo(7.5098f, 21.7f, 7.2098f, 21.33f, 7.2598f, 20.92f)
            lineTo(9.2598f, 2.92f)
            curveTo(9.3098f, 2.51f, 9.6798f, 2.22f, 10.0898f, 2.26f)
            curveTo(10.4998f, 2.31f, 10.7998f, 2.68f, 10.7498f, 3.09f)
            lineTo(8.7498f, 21.09f)
            curveTo(8.6998f, 21.47f, 8.3798f, 21.75f, 7.9998f, 21.75f)
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
            moveTo(13.9998f, 21.75f)
            curveTo(13.9698f, 21.75f, 13.9398f, 21.75f, 13.9198f, 21.75f)
            curveTo(13.5098f, 21.7f, 13.2098f, 21.33f, 13.2598f, 20.92f)
            lineTo(15.2598f, 2.92f)
            curveTo(15.3098f, 2.51f, 15.6698f, 2.22f, 16.0898f, 2.26f)
            curveTo(16.4998f, 2.31f, 16.7998f, 2.68f, 16.7498f, 3.09f)
            lineTo(14.7498f, 21.09f)
            curveTo(14.6998f, 21.47f, 14.3798f, 21.75f, 13.9998f, 21.75f)
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
            moveTo(21.5f, 9.75f)
            horizontalLineTo(3.5f)
            curveTo(3.09f, 9.75f, 2.75f, 9.41f, 2.75f, 9.0f)
            curveTo(2.75f, 8.59f, 3.09f, 8.25f, 3.5f, 8.25f)
            horizontalLineTo(21.5f)
            curveTo(21.91f, 8.25f, 22.25f, 8.59f, 22.25f, 9.0f)
            curveTo(22.25f, 9.41f, 21.91f, 9.75f, 21.5f, 9.75f)
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
            moveTo(20.5f, 15.75f)
            horizontalLineTo(2.5f)
            curveTo(2.09f, 15.75f, 1.75f, 15.41f, 1.75f, 15.0f)
            curveTo(1.75f, 14.59f, 2.09f, 14.25f, 2.5f, 14.25f)
            horizontalLineTo(20.5f)
            curveTo(20.91f, 14.25f, 21.25f, 14.59f, 21.25f, 15.0f)
            curveTo(21.25f, 15.41f, 20.91f, 15.75f, 20.5f, 15.75f)
            close()
        }
    }
        .build()
}

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

val AntonIcons.MessageAdd: ImageVector by lazy {
    Builder(
        name = "Message-add", defaultWidth = 15.0.dp, defaultHeight =
        15.0.dp, viewportWidth = 15.0f, viewportHeight = 15.0f
    ).apply {
        path(
            fill = SolidColor(Color(0xFFffffff)), stroke = null, fillAlpha = 0.4f, strokeAlpha
            = 0.4f, strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
            strokeLineMiter = 4.0f, pathFillType = NonZero
        ) {
            moveTo(10.0f, 1.25f)
            horizontalLineTo(5.0f)
            curveTo(2.5f, 1.25f, 1.25f, 2.5f, 1.25f, 5.0f)
            verticalLineTo(13.125f)
            curveTo(1.25f, 13.4688f, 1.5313f, 13.75f, 1.875f, 13.75f)
            horizontalLineTo(10.0f)
            curveTo(12.5f, 13.75f, 13.75f, 12.5f, 13.75f, 10.0f)
            verticalLineTo(5.0f)
            curveTo(13.75f, 2.5f, 12.5f, 1.25f, 10.0f, 1.25f)
            close()
        }
        path(
            fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
            strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
            pathFillType = NonZero
        ) {
            moveTo(9.6875f, 7.0313f)
            horizontalLineTo(7.9688f)
            verticalLineTo(5.3125f)
            curveTo(7.9688f, 5.0563f, 7.7562f, 4.8438f, 7.5f, 4.8438f)
            curveTo(7.2438f, 4.8438f, 7.0313f, 5.0563f, 7.0313f, 5.3125f)
            verticalLineTo(7.0313f)
            horizontalLineTo(5.3125f)
            curveTo(5.0563f, 7.0313f, 4.8438f, 7.2438f, 4.8438f, 7.5f)
            curveTo(4.8438f, 7.7562f, 5.0563f, 7.9688f, 5.3125f, 7.9688f)
            horizontalLineTo(7.0313f)
            verticalLineTo(9.6875f)
            curveTo(7.0313f, 9.9438f, 7.2438f, 10.1562f, 7.5f, 10.1562f)
            curveTo(7.7562f, 10.1562f, 7.9688f, 9.9438f, 7.9688f, 9.6875f)
            verticalLineTo(7.9688f)
            horizontalLineTo(9.6875f)
            curveTo(9.9438f, 7.9688f, 10.1562f, 7.7562f, 10.1562f, 7.5f)
            curveTo(10.1562f, 7.2438f, 9.9438f, 7.0313f, 9.6875f, 7.0313f)
            close()
        }
    }
        .build()
}

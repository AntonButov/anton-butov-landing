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

val AntonIcons.Scroll: ImageVector by lazy {
    Builder(
        name = "Scroll",
        defaultWidth = 24.0.dp,
        defaultHeight = 24.0.dp,
        viewportWidth = 24.0f,
        viewportHeight = 24.0f,
    ).apply {
        path(
            fill = SolidColor(Color(0xFFffffff)), stroke = null, fillAlpha = 0.4f,
            strokeAlpha =
            0.4f,
            strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
            strokeLineMiter = 4.0f, pathFillType = NonZero,
        ) {
            moveTo(16.19f, 2.0f)
            horizontalLineTo(7.81f)
            curveTo(4.17f, 2.0f, 2.0f, 4.17f, 2.0f, 7.81f)
            verticalLineTo(16.18f)
            curveTo(2.0f, 19.83f, 4.17f, 22.0f, 7.81f, 22.0f)
            horizontalLineTo(16.18f)
            curveTo(19.82f, 22.0f, 21.99f, 19.83f, 21.99f, 16.19f)
            verticalLineTo(7.81f)
            curveTo(22.0f, 4.17f, 19.83f, 2.0f, 16.19f, 2.0f)
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
            moveTo(9.6002f, 15.7799f)
            curveTo(9.4102f, 15.7799f, 9.2202f, 15.7099f, 9.0702f, 15.5599f)
            lineTo(6.5802f, 13.0699f)
            curveTo(5.9902f, 12.4799f, 5.9902f, 11.5299f, 6.5802f, 10.9399f)
            lineTo(9.0702f, 8.4499f)
            curveTo(9.3602f, 8.1599f, 9.8402f, 8.1599f, 10.1302f, 8.4499f)
            curveTo(10.4202f, 8.7399f, 10.4202f, 9.2199f, 10.1302f, 9.5099f)
            lineTo(7.6402f, 11.9999f)
            lineTo(10.1302f, 14.4999f)
            curveTo(10.4202f, 14.7899f, 10.4202f, 15.2699f, 10.1302f, 15.5599f)
            curveTo(9.9802f, 15.6999f, 9.7902f, 15.7799f, 9.6002f, 15.7799f)
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
            moveTo(14.3998f, 15.7802f)
            curveTo(14.2098f, 15.7802f, 14.0198f, 15.7102f, 13.8698f, 15.5602f)
            curveTo(13.5798f, 15.2702f, 13.5798f, 14.7902f, 13.8698f, 14.5002f)
            lineTo(16.3598f, 12.0002f)
            lineTo(13.8698f, 9.5002f)
            curveTo(13.5798f, 9.2102f, 13.5798f, 8.7302f, 13.8698f, 8.4402f)
            curveTo(14.1598f, 8.1502f, 14.6398f, 8.1502f, 14.9298f, 8.4402f)
            lineTo(17.4198f, 10.9302f)
            curveTo(18.0098f, 11.5202f, 18.0098f, 12.4702f, 17.4198f, 13.0602f)
            lineTo(14.9298f, 15.5502f)
            curveTo(14.7898f, 15.7002f, 14.5898f, 15.7802f, 14.3998f, 15.7802f)
            close()
        }
    }
        .build()
}

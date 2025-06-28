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
import dev.butov.anton.AntonIcons

val AntonIcons.Call: ImageVector by lazy {
        Builder(name = "Call", defaultWidth = 16.0.dp, defaultHeight = 16.0.dp,
                viewportWidth = 16.0f, viewportHeight = 16.0f).apply {
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(12.82f, 10.1735f)
                lineTo(11.1267f, 9.9802f)
                curveTo(10.9276f, 9.9568f, 10.7258f, 9.9788f, 10.5364f, 10.0446f)
                curveTo(10.347f, 10.1105f, 10.175f, 10.2183f, 10.0334f, 10.3602f)
                lineTo(8.8067f, 11.5868f)
                curveTo(6.9143f, 10.6241f, 5.3761f, 9.0859f, 4.4134f, 7.1935f)
                lineTo(5.6467f, 5.9602f)
                curveTo(5.9334f, 5.6735f, 6.0734f, 5.2735f, 6.0267f, 4.8668f)
                lineTo(5.8334f, 3.1868f)
                curveTo(5.7957f, 2.8616f, 5.6397f, 2.5615f, 5.395f, 2.3439f)
                curveTo(5.1503f, 2.1263f, 4.8341f, 2.0063f, 4.5067f, 2.0068f)
                horizontalLineTo(3.3534f)
                curveTo(2.6f, 2.0068f, 1.9734f, 2.6335f, 2.02f, 3.3868f)
                curveTo(2.3734f, 9.0802f, 6.9267f, 13.6268f, 12.6134f, 13.9802f)
                curveTo(13.3667f, 14.0268f, 13.9934f, 13.4002f, 13.9934f, 12.6468f)
                verticalLineTo(11.4935f)
                curveTo(14.0f, 10.8202f, 13.4934f, 10.2535f, 12.82f, 10.1735f)
                close()
            }
        }
        .build()
    }

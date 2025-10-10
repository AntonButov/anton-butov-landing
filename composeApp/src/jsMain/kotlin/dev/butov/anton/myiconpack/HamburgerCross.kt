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

val AntonIcons.HamburgerCross: ImageVector by lazy {
    Builder(
        name = "HamburgerCross",
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
            moveTo(12.7071f, 31.0917f)
            lineTo(31.0919f, 12.7069f)
            arcTo(1.0f, 1.0f, 83.3714f, false, true, 32.5061f, 12.7069f)
            lineTo(32.5061f, 12.7069f)
            arcTo(1.0f, 1.0f, 83.3714f, false, true, 32.5061f, 14.1211f)
            lineTo(14.1213f, 32.5059f)
            arcTo(1.0f, 1.0f, 0.0f, false, true, 12.7071f, 32.5059f)
            lineTo(12.7071f, 32.5059f)
            arcTo(1.0f, 1.0f, 119.0546f, false, true, 12.7071f, 31.0917f)
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
            moveTo(31.0917f, 32.5068f)
            lineTo(12.7069f, 14.122f)
            arcTo(1.0f, 1.0f, 0.0f, false, true, 12.7069f, 12.7078f)
            lineTo(12.7069f, 12.7078f)
            arcTo(1.0f, 1.0f, 0.0f, false, true, 14.1211f, 12.7078f)
            lineTo(32.5059f, 31.0926f)
            arcTo(1.0f, 1.0f, 0.0f, false, true, 32.5059f, 32.5068f)
            lineTo(32.5059f, 32.5068f)
            arcTo(1.0f, 1.0f, 0.0f, false, true, 31.0917f, 32.5068f)
            close()
        }
    }
        .build()
}

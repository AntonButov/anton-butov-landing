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
import dev.butov.anton.MyIconPack

val AntonIcons.Teleg: ImageVector by lazy {
    Builder(
        name = "Teleg", defaultWidth = 25.0.dp, defaultHeight = 20.0.dp,
        viewportWidth = 25.0f, viewportHeight = 20.0f
    ).apply {
        path(
            fill = SolidColor(Color(0xFFffffff)), stroke = null, fillAlpha = 0.6f,
            strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
            strokeLineMiter = 4.0f, pathFillType = NonZero
        ) {
            moveTo(22.88f, 0.1315f)
            lineTo(1.6207f, 8.2774f)
            curveTo(0.1698f, 8.8564f, 0.1782f, 9.6606f, 1.3545f, 10.0192f)
            lineTo(6.8126f, 11.7111f)
            lineTo(19.4411f, 3.794f)
            curveTo(20.0383f, 3.433f, 20.5838f, 3.6272f, 20.1354f, 4.0227f)
            lineTo(9.9038f, 13.198f)
            horizontalLineTo(9.9014f)
            lineTo(9.9038f, 13.1992f)
            lineTo(9.5273f, 18.7894f)
            curveTo(10.0788f, 18.7894f, 10.3222f, 18.538f, 10.6316f, 18.2414f)
            lineTo(13.2827f, 15.6798f)
            lineTo(18.7972f, 19.7271f)
            curveTo(19.814f, 20.2835f, 20.5443f, 19.9975f, 20.7973f, 18.7918f)
            lineTo(24.4172f, 1.84f)
            curveTo(24.7877f, 0.3638f, 23.8501f, -0.3046f, 22.88f, 0.1315f)
            close()
        }
    }
        .build()
}

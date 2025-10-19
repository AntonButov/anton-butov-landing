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

val AntonIcons.BrasessOff: ImageVector by lazy {
    Builder(
        name = "Brasessoff",
        defaultWidth = 39.0.dp,
        defaultHeight = 35.0.dp,
        viewportWidth = 39.0f,
        viewportHeight = 35.0f,
    ).apply {
        path(
            fill = SolidColor(Color(0xFFE20100)),
            stroke = null,
            fillAlpha = 0.82f,
            strokeLineWidth = 0.0f,
            strokeLineCap = Butt,
            strokeLineJoin = Miter,
            strokeLineMiter = 4.0f,
            pathFillType = NonZero,
        ) {
            moveTo(39.0f, 21.0619f)
            lineTo(19.8448f, 35.0f)
            verticalLineTo(26.0177f)
            lineTo(31.721f, 17.5774f)
            lineTo(19.7682f, 9.292f)
            verticalLineTo(0.0f)
            lineTo(39.0f, 13.9381f)
            verticalLineTo(21.0619f)
            close()
            moveTo(19.2318f, 21.0619f)
            lineTo(0.0766f, 35.0f)
            verticalLineTo(26.0177f)
            lineTo(11.9529f, 17.5774f)
            lineTo(0.0f, 9.292f)
            verticalLineTo(0.0f)
            lineTo(19.2318f, 13.9381f)
            verticalLineTo(21.0619f)
            close()
        }
    }
        .build()
}

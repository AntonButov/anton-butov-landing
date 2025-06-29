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

val AntonIcons.Arrow: ImageVector by lazy {
    Builder(
        name = "Arrow",
        defaultWidth = 41.0.dp,
        defaultHeight = 38.0.dp,
        viewportWidth = 41.0f,
        viewportHeight = 38.0f,
    ).apply {
        path(
            fill = SolidColor(Color(0xFFffffff)), stroke = null, fillAlpha = 0.1f,
            strokeAlpha =
            0.1f,
            strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
            strokeLineMiter = 4.0f, pathFillType = NonZero,
        ) {
            moveTo(40.1129f, 23.4723f)
            lineTo(0.0f, 37.9048f)
            verticalLineTo(29.7738f)
            lineTo(30.0846f, 19.068f)
            lineTo(0.0f, 8.3622f)
            verticalLineTo(0.0957f)
            lineTo(40.1129f, 14.5282f)
            verticalLineTo(23.4723f)
            close()
        }
    }
        .build()
}

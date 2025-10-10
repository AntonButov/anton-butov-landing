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

val AntonIcons.Kotlin: ImageVector by lazy {
    Builder(
        name = "Kotlin",
        defaultWidth = 20.0.dp,
        defaultHeight = 20.0.dp,
        viewportWidth = 20.0f,
        viewportHeight = 20.0f,
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
            moveTo(20.0f, 20.0f)
            horizontalLineTo(0.0f)
            verticalLineTo(0.0f)
            horizontalLineTo(20.0f)
            lineTo(9.793f, 9.855f)
            lineTo(20.0f, 20.0f)
            close()
        }
    }
        .build()
}

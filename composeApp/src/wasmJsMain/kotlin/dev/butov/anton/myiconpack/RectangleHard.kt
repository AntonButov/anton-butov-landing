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

val AntonIcons.RectangleHard: ImageVector by lazy {
    Builder(
        name = "Rectangle 11",
        defaultWidth = 13.0.dp,
        defaultHeight =
            13.0.dp,
        viewportWidth = 13.0f,
        viewportHeight = 13.0f,
    ).apply {
        path(
            fill = SolidColor(Color(0xFFD9D9D9)), stroke = null, fillAlpha = 0.10f,
            strokeAlpha =
            0.05f,
            strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
            strokeLineMiter = 4.0f, pathFillType = NonZero,
        ) {
            moveTo(0.0f, 0.0f)
            horizontalLineToRelative(13.0f)
            verticalLineToRelative(13.0f)
            horizontalLineToRelative(-13.0f)
            close()
        }
    }
        .build()
}

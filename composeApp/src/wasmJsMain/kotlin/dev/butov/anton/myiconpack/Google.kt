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

val AntonIcons.Google: ImageVector by lazy {
    Builder(
        name = "Googlefill",
        defaultWidth = 24.0.dp,
        defaultHeight = 24.0.dp,
        viewportWidth = 24.0f,
        viewportHeight = 24.0f,
    ).apply {
        path(
            fill = SolidColor(Color(0xFF000000)),
            stroke = null,
            strokeLineWidth = 0.0f,
            strokeLineCap = Butt,
            strokeLineJoin = Miter,
            strokeLineMiter = 4.0f,
            pathFillType = NonZero,
        ) {
            moveTo(21.456f, 10.154f)
            curveToRelative(0.123f, 0.659f, 0.19f, 1.348f, 0.19f, 2.067f)
            curveToRelative(0.0f, 5.624f, -3.764f, 9.623f, -9.449f, 9.623f)
            arcTo(9.841f, 9.841f, 0.0f, false, true, 2.353f, 12.0f)
            arcToRelative(9.841f, 9.841f, 0.0f, false, true, 9.844f, -9.844f)
            curveToRelative(2.658f, 0.0f, 4.879f, 0.978f, 6.583f, 2.566f)
            lineToRelative(-2.775f, 2.775f)
            verticalLineTo(7.49f)
            curveToRelative(-1.033f, -0.984f, -2.344f, -1.489f, -3.808f, -1.489f)
            curveToRelative(-3.248f, 0.0f, -5.888f, 2.744f, -5.888f, 5.993f)
            curveToRelative(0.0f, 3.248f, 2.64f, 5.999f, 5.888f, 5.999f)
            curveToRelative(2.947f, 0.0f, 4.953f, -1.686f, 5.365f, -4.0f)
            horizontalLineToRelative(-5.365f)
            verticalLineToRelative(-3.839f)
            close()
        }
    }
        .build()
}

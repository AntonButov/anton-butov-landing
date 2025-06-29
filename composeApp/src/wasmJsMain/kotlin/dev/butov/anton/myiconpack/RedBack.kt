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

val AntonIcons.RedBack: ImageVector by lazy {
    Builder(
        name = "Redback",
        defaultWidth = 1440.0.dp,
        defaultHeight = 1486.0.dp,
        viewportWidth = 1440.0f,
        viewportHeight = 1486.0f,
    ).apply {
        path(
            fill = SolidColor(Color(0xFFE20100)), stroke = null, fillAlpha = 0.204f,
            strokeAlpha = 0.6f, strokeLineWidth = 0.0f, strokeLineCap = Butt,
            strokeLineJoin =
            Miter,
            strokeLineMiter = 4.0f, pathFillType = NonZero,
        ) {
            moveTo(165.0f, 803.0f)
            arcToRelative(294.5f, 233.0f, 0.0f, true, false, 589.0f, 0.0f)
            arcToRelative(294.5f, 233.0f, 0.0f, true, false, -589.0f, 0.0f)
            close()
        }
        path(
            fill = SolidColor(Color(0xFFE20100)), stroke = null, fillAlpha = 0.204f,
            strokeAlpha = 0.6f, strokeLineWidth = 0.0f, strokeLineCap = Butt,
            strokeLineJoin =
            Miter,
            strokeLineMiter = 4.0f, pathFillType = NonZero,
        ) {
            moveTo(687.0f, 683.0f)
            arcToRelative(294.5f, 233.0f, 0.0f, true, false, 589.0f, 0.0f)
            arcToRelative(294.5f, 233.0f, 0.0f, true, false, -589.0f, 0.0f)
            close()
        }
    }
        .build()
}

package dev.butov.anton.myiconpack

import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val AntonIcons.Go: ImageVector by lazy {
        Builder(name = "Go", defaultWidth = 70.0.dp, defaultHeight = 69.0.dp, viewportWidth =
                70.0f, viewportHeight = 69.0f).apply {
            path(fill = null, stroke = null, strokeLineWidth = 0.0f, strokeLineCap = Butt,
                    strokeLineJoin = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(12.5f, 0.0f)
                lineTo(57.5f, 0.0f)
                arcTo(12.0f, 12.0f, 0.0f, false, true, 69.5f, 12.0f)
                lineTo(69.5f, 57.0f)
                arcTo(12.0f, 12.0f, 0.0f, false, true, 57.5f, 69.0f)
                lineTo(12.5f, 69.0f)
                arcTo(12.0f, 12.0f, 0.0f, false, true, 0.5f, 57.0f)
                lineTo(0.5f, 12.0f)
                arcTo(12.0f, 12.0f, 0.0f, false, true, 12.5f, 0.0f)
                close()
            }
        }
        .build()
    }

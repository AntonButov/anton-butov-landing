package dev.butov.anton.myiconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val AntonIcons.ClickArrow: ImageVector by lazy {
        Builder(name = "Clickarrow", defaultWidth = 38.0.dp, defaultHeight = 37.0.dp,
                viewportWidth = 38.0f, viewportHeight = 37.0f).apply {
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, fillAlpha = 0.1f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(19.0f, 18.5f)
                moveToRelative(-18.5f, 0.0f)
                arcToRelative(18.5f, 18.5f, 0.0f, true, true, 37.0f, 0.0f)
                arcToRelative(18.5f, 18.5f, 0.0f, true, true, -37.0f, 0.0f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFffffff)),
                    strokeLineWidth = 1.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(13.6968f, 23.8029f)
                lineTo(24.3034f, 13.1963f)
                moveTo(24.3034f, 13.1963f)
                horizontalLineTo(13.6968f)
                moveTo(24.3034f, 13.1963f)
                verticalLineTo(23.8029f)
            }
        }
        .build()
    }

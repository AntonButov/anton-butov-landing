package dev.butov.anton

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import antonbutov.composeapp.generated.resources.Inter_28pt_Medium
import antonbutov.composeapp.generated.resources.Inter_28pt_Regular
import antonbutov.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

@Composable
fun InterFonts() = FontFamily(
    Font(
        resource = Res.font.Inter_28pt_Regular,
        weight = FontWeight.Normal,
    ),
    Font(
        resource = Res.font.Inter_28pt_Medium,
        weight = FontWeight.Medium,
    )

)
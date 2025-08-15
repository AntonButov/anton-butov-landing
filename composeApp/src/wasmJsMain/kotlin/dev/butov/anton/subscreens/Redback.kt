package dev.butov.anton.subscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import antonbutov.composeapp.generated.resources.Res
import antonbutov.composeapp.generated.resources.redBack
import org.jetbrains.compose.resources.painterResource

@Composable
fun Redback() {
    Image(
        modifier =
            Modifier
                .fillMaxWidth(),
        painter = painterResource(Res.drawable.redBack),
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
    )
}

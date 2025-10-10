package dev.butov.anton.subscreens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import antonbutov.composeapp.generated.resources.Res
import antonbutov.composeapp.generated.resources.redBack
import antonbutov.composeapp.generated.resources.redBackMobile
import dev.butov.anton.LocalIsMobile
import dev.butov.anton.components.AsyncImage

@Composable
fun Redback() {
    val isMobile = LocalIsMobile.current
    AsyncImage(
        resource = if (isMobile) Res.drawable.redBackMobile else Res.drawable.redBack,
        contentDescription = null,
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.FillWidth
    )
}

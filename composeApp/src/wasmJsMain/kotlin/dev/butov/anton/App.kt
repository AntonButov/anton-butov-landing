package dev.butov.anton

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import org.jetbrains.compose.resources.painterResource

import antonbutov.composeapp.generated.resources.Res
import antonbutov.composeapp.generated.resources.compose_multiplatform
import antonbutov.composeapp.generated.resources.redBack

@Composable
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(
        //    modifier = Modifier
        //        .safeContentPadding()
        //        .fillMaxSize(),
        //    horizontalAlignment = Alignment.CenterHorizontally,
        ) {
          //  Image(
         //       modifier = Modifier.weight(3f).fillMaxSize(),
          //      painter = painterResource("redBack.svg"),
          //      contentScale = ContentScale.FillBounds,
         //       contentDescription = null
          //  )

            Image(painter = painterResource(Res.drawable.redBack), contentDescription = null)
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }
    }
}
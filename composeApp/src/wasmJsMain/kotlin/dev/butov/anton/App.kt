package dev.butov.anton

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource

import antonbutov.composeapp.generated.resources.Res
import antonbutov.composeapp.generated.resources.compose_multiplatform
import antonbutov.composeapp.generated.resources.redBack

@Composable
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        LazyColumn(
            modifier = Modifier.background(color = Colors.background),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            item {
                Image(
                    modifier = Modifier.padding(horizontal = 160.dp, vertical = 10.dp),
                    painter = painterResource(Res.drawable.redBack), contentDescription = null
                )
                Button(onClick = { showContent = !showContent }) {
                    Text("Click me!")
                }
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
}
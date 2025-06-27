package dev.butov.anton

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.*
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
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier.background(color = Color.LightGray),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                item {
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

            LazyColumn() {
                item {
                    Box(
                        Modifier
                            .background(Colors.background)
                            .height(3500.dp)
                            .fillMaxWidth()
                    ) {
                        Row(
                            Modifier
                                .fillMaxSize()
                                .padding(horizontal = 80.dp)
                        ) {
                            VerticalDivider(color = Colors.onBackground)
                            Spacer(Modifier.weight(1f))
                            VerticalDivider(color = Colors.onBackground)
                            Spacer(Modifier.weight(1f))
                            VerticalDivider(color = Colors.onBackground)
                            Spacer(Modifier.weight(1f))
                            VerticalDivider(color = Colors.onBackground)
                            Spacer(Modifier.weight(1f))
                            VerticalDivider(color = Colors.onBackground)
                        }
                            Image(
                                modifier = Modifier.fillMaxWidth().padding(horizontal = 80.dp, vertical = 550.dp),
                                painter = painterResource(Res.drawable.redBack), contentDescription = null,
                                contentScale = ContentScale.FillBounds
                            )
                        }
                }
            }
        }
    }
}


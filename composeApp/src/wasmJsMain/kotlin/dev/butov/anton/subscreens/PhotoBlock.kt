package dev.butov.anton.subscreens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import antonbutov.composeapp.generated.resources.Res
import antonbutov.composeapp.generated.resources.butov
import dev.butov.anton.Colors
import dev.butov.anton.LocalIsMobile
import dev.butov.anton.components.AsyncImage
import dev.butov.anton.subscreens.burger.HamburgerMenu
import dev.butov.anton.subscreens.burger.MenuViewModel
import dev.butov.anton.uikit.CallButtonLight
import dev.butov.anton.uikit.FullStyle
import dev.butov.anton.uikit.FullStyleUnderline
import dev.butov.anton.uikit.SoftStyle
import org.jetbrains.compose.resources.painterResource

@Composable
fun PhotoBlock(menuViewModel: MenuViewModel) {
    val isMobile = LocalIsMobile.current
    BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
        HamburgerMenu(viewModel = menuViewModel)
        if (isMobile) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                AsyncImage(
                    resource = Res.drawable.butov,
                    contentDescription = "Butov",
                    modifier = Modifier.height(300.dp)
                )
                Spacer(Modifier.size(6.dp))
                Im(isMobile = isMobile)
            }
        } else {
            Row(modifier = Modifier.fillMaxWidth()) {
                Im(modifier = Modifier.align(Alignment.Bottom), isMobile)
                Spacer(Modifier.weight(1f))
                AsyncImage(
                    resource = Res.drawable.butov,
                    contentDescription = "Butov",
                    modifier = Modifier.height(600.dp)
                )
            }
        }
    }
}

@Composable
private fun Im(
    modifier: Modifier = Modifier,
    isMobile: Boolean,
) {
    Column(
        modifier = if (isMobile) modifier.fillMaxWidth() else modifier,
        horizontalAlignment = if (isMobile) Alignment.CenterHorizontally else Alignment.Start,
    ) {
        val firstText =
            buildAnnotatedString {
                SoftStyle {
                    append("I'm ")
                }
                FullStyle {
                    append("Anton Butov\n")
                }
                SoftStyle {
                    append("and I'm a ")
                }
                FullStyle {
                    append("Senior ")
                }
                if (isMobile) append("\n")
                FullStyle {
                    append("Android ")
                }
                FullStyleUnderline {
                    append("Developer")
                }
            }
        Text(
            text = firstText,
            style =
                if (isMobile) {
                    MaterialTheme.typography.displaySmall
                } else {
                    MaterialTheme.typography.displayMedium.copy(
                        fontWeight = FontWeight.Medium,
                    )
                },
            textAlign = if (isMobile) TextAlign.Center else TextAlign.Start,
        )
        Spacer(Modifier.size(24.dp))
        val secondText = "Nice to meet you."
        Text(
            text = secondText,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Light,
            color = Colors.primary.copy(alpha = 0.6f),
        )
        Spacer(Modifier.size(24.dp))
        CallButtonLight()
    }
}

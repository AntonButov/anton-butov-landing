package dev.butov.anton.subscreens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import antonbutov.composeapp.generated.resources.*
import antonbutov.composeapp.generated.resources.Res
import antonbutov.composeapp.generated.resources.go
import antonbutov.composeapp.generated.resources.iva
import dev.butov.anton.Colors
import dev.butov.anton.TechnologiesEnum
import dev.butov.anton.myiconpack.*
import dev.butov.anton.uikit.FullStyle
import dev.butov.anton.uikit.SoftStyle
import org.jetbrains.compose.resources.painterResource

@Composable
fun MyProjects() {
    Column {
        Text(
            text =
                buildAnnotatedString {
                    SoftStyle {
                        append("My ")
                    }
                    FullStyle {
                        append("Projects:")
                    }
                },
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Medium),
        )
        Spacer(Modifier.size(36.dp))
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            ProjectIva()
            ProjectGo()
            ProjectAlerton()
            ProjectDaggerDsl()
        }
    }
}

@Composable
private fun ProjectDaggerDsl() {
    Project(
        painter = painterResource(Res.drawable.git),
        name = "Dagger DSL",
        time = "2024-2025",
        technologies =
            listOf(
                { TechnologyButton(TechnologiesEnum.KotlinPoet) },
                { TechnologyButton(TechnologiesEnum.KSP) },
            ),
    )
}

@Composable
private fun ProjectGo() {
    Project(
        painter = painterResource(Res.drawable.go),
        name = "Yandex GO",
        time = "2023-2024",
        technologies =
            listOf(
                { TechnologyButton(TechnologiesEnum.Kotlin) },
                { TechnologyButton(TechnologiesEnum.Java) },
                { TechnologyButton(TechnologiesEnum.Dagger) },
            ),
    )
}

@Composable
private fun ProjectAlerton() {
    Project(
        painter = painterResource(Res.drawable.alerton),
        name = "Alerton",
        time = "2022-2023",
        technologies =
            listOf(
                { TechnologyButton(TechnologiesEnum.WEBRTC) },
                { TechnologyButton(TechnologiesEnum.JetpackCompose) },
            ),
    )
}

@Composable
private fun ProjectIva() {
    Project(
        painter = painterResource(Res.drawable.iva),
        name = "Iva Connect",
        time = "2022-2023",
        technologies =
            listOf(
                { TechnologyButton(TechnologiesEnum.WEBRTC) },
                { TechnologyButton(TechnologiesEnum.JetpackCompose) },
            ),
    )
}

@Composable
private fun Project(
    painter: Painter,
    name: String,
    time: String,
    technologies: List<@Composable () -> Unit>,
) {
    Box(
        Modifier
            .height(270.dp)
            .width(300.dp)
            .clip(MaterialTheme.shapes.small)
            .background(Colors.background.copy(alpha = 0.04f))
            .border(1.dp, Colors.primary.copy(alpha = 0.05f), MaterialTheme.shapes.small)
            .padding(horizontal = 14.dp, vertical = 16.dp),
    ) {
        Row {
            Icon(
                painter = painter,
                contentDescription = null,
                tint = Color.Unspecified,
            )
            Spacer(Modifier.weight(1f))
            ClickIcon(Modifier.align(Alignment.CenterVertically))
        }
        Column(
            modifier = Modifier.align(Alignment.BottomStart),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            ProjectName(name, time)
            Spacer(Modifier.size(20.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                technologies.forEach {
                    it()
                }
            }
        }
    }
}

@Composable
private fun ClickIcon(modifier: Modifier) {
    Icon(
        modifier = modifier,
        imageVector = AntonIcons.ClickArrow,
        contentDescription = null,
    )
}

@Composable
private fun ProjectIcon(imageVector: ImageVector) {
    Icon(
        imageVector = imageVector,
        contentDescription = null,
    )
}

@Composable
private fun ProjectIcon(painter: Painter) {
    Icon(
        painter = painter,
        contentDescription = null,
    )
}

@Composable
private fun ProjectName(
    name: String,
    time: String,
) {
    Column {
        Text(
            text = name,
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.SemiBold),
        )
        Text(
            text =
                buildAnnotatedString {
                    SoftStyle {
                        append(time)
                    }
                },
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Normal),
        )
    }
}

@Composable
private fun TechnologyButton(technology: TechnologiesEnum) {
    Box(
        modifier =
            Modifier
                .clip(MaterialTheme.shapes.small)
                .border(1.dp, Colors.primary.copy(alpha = 0.2f), MaterialTheme.shapes.small)
                .background(Colors.primary.copy(alpha = 0.1f)),
        contentAlignment = Alignment.Center,
    ) {
        Row(Modifier.height(40.dp).padding(horizontal = 13.dp).padding(vertical = 11.dp)) {
            Icon(
                modifier = Modifier.size(15.dp).align(Alignment.CenterVertically),
                imageVector = technology.imageVector,
                contentDescription = null,
            )
            Spacer(Modifier.size(6.dp))
            Text(
                modifier = Modifier.align(Alignment.CenterVertically),
                text = technology.text,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Normal, letterSpacing = -0.03.sp),
            )
        }
    }
}

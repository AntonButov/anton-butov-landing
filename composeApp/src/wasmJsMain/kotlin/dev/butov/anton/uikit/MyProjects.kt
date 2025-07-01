package dev.butov.anton.uikit

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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.butov.anton.Colors
import dev.butov.anton.InterFonts
import dev.butov.anton.TechnologiesEnum
import dev.butov.anton.myiconpack.AntonIcons
import dev.butov.anton.myiconpack.Go

@Composable
fun MyProjects() {
    Column {
        Text(
            text = buildAnnotatedString {
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
            ProjectGo()
        }
    }
}

@Composable
private fun ProjectGo() {
    Project(
        imageVector = AntonIcons.Go,
        name = "Yandex GO",
        time = "2023-2024",
        technologies = listOf(
            { TechnologyButton(TechnologiesEnum.Kotlin) },
            { TechnologyButton(TechnologiesEnum.Java) },
            { TechnologyButton(TechnologiesEnum.Dagger) },
        )
    )
}

@Composable
private fun Project(imageVector: ImageVector, name: String, time: String, technologies: List<@Composable () -> Unit>) {
    Box(Modifier
        .height(300.dp)
        .width(270.dp)
        .clip(MaterialTheme.shapes.small)
        .border(1.dp, Colors.primary.copy(alpha = 0.5f), MaterialTheme.shapes.small)
        .background(Colors.background.copy(alpha = 0.4f))
        .padding(horizontal = 14.dp, vertical = 16.dp)
    ) {
        ProjectIcon(imageVector)
        Column(
            modifier = Modifier.align(Alignment.BottomCenter),
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
private fun BoxScope.ProjectIcon(imageVector: ImageVector) {
    Icon(
        modifier = Modifier.align(Alignment.TopStart),
        imageVector = imageVector,
        contentDescription = null,
    )
}

@Composable
private fun ProjectName(name: String, time: String) {
    Column {
        Text(
            text = name,
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.SemiBold),
        )
        Text(
            text = buildAnnotatedString {
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
        modifier = Modifier
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
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Normal),
            )
        }
    }
}


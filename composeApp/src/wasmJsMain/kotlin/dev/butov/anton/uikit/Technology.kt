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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.butov.anton.Colors
import dev.butov.anton.myiconpack.*

@Composable
fun Technologies() {
    FlowRow(
        modifier =
            Modifier
                .clip(MaterialTheme.shapes.medium)
                .background(Colors.background.copy(alpha = 0.45f))
                .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(7.dp),
        verticalArrangement = Arrangement.spacedBy(7.dp),
    ) {
        TechnologyHeader()
        TechnologyKotlin()
        TechnologyJava()
        TechnologyCompose()
        TechnologyDagger()
        TechnologyCleanArchitecture()
        TechnologyTDD()
        TechnologyKMP()
    }
}

@Composable
private fun Technology(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit,
) {
    Box(modifier.height(110.dp).width(155.dp)) {
        content()
    }
}

@Composable
private fun TechnologyHeader(modifier: Modifier = Modifier) {
    Technology {
        Text(
            modifier = modifier.align(Alignment.TopStart),
            text = "My technologies:",
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@Composable
private fun TechnologyKotlin() {
    Technology(
        modifierIcon =
            Modifier
                .padding(start = 15.dp, top = 14.dp),
        icon = AntonIcons.Kotlin,
        technology = "Kotlin",
        experience = "5 years", // todo by now
    )
}

@Composable
private fun TechnologyJava() {
    Technology(
        modifierIcon =
            Modifier
                .padding(start = 15.dp, top = 10.dp),
        icon = AntonIcons.Java,
        technology = "Java",
        experience = "5 years", // todo by now
    )
}

@Composable
private fun TechnologyCompose() {
    Technology(
        modifierIcon =
            Modifier
                .padding(start = 13.dp, top = 10.dp),
        icon = AntonIcons.Compose,
        technology = "Jetpack Compose",
        experience = "3 years", // todo by now
    )
}

@Composable
private fun TechnologyDagger() {
    Technology(
        modifierIcon =
            Modifier
                .padding(start = 12.dp, top = 10.dp),
        icon = AntonIcons.Google,
        technology = "Dagger",
        experience = "5 years", // todo by now
    )
}

@Composable
private fun TechnologyCleanArchitecture() {
    Technology(
        modifierIcon =
            Modifier
                .padding(start = 13.dp, top = 10.dp),
        icon = AntonIcons.Android,
        technology = "Clear Architecture",
        experience = "5 years", // todo by now
    )
}

@Composable
private fun TechnologyTDD() {
    Technology(
        modifierIcon =
            Modifier
                .padding(start = 13.dp, top = 10.dp),
        icon = AntonIcons.Android,
        technology = "TDD",
        experience = "5 years", // todo by now
    )
}

@Composable
private fun TechnologyKMP() {
    Technology(
        modifierIcon =
            Modifier
                .padding(start = 13.dp, top = 10.dp),
        icon = AntonIcons.Kotlin,
        technology = "KMP",
        experience = "3 years", // todo by now
    )
}

@Composable
private fun Technology(
    modifierIcon: Modifier,
    icon: ImageVector,
    technology: String,
    experience: String,
) {
    Technology(
        modifier =
            Modifier
                .clip(MaterialTheme.shapes.medium)
                .border(1.dp, Colors.primary.copy(alpha = 0.4f), MaterialTheme.shapes.medium)
                .background(Colors.primary.copy(alpha = 0.2f)),
    ) {
        Icon(
            modifier = modifierIcon,
            imageVector = icon,
            contentDescription = null,
        )
        Column(modifier = Modifier.align(Alignment.BottomStart).padding(horizontal = 15.dp, vertical = 13.dp)) {
            Text(
                text = technology,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = experience,
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Light),
            )
        }
    }
}

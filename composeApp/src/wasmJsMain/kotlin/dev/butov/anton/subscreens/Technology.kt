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
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.butov.anton.Colors
import dev.butov.anton.LocalIsMobile
import dev.butov.anton.TechnologiesEnum
import dev.butov.anton.currentYear

@Composable
fun Technologies() {
    val isMobile = LocalIsMobile.current
    Column(
        Modifier
            .clip(MaterialTheme.shapes.medium)
            .background(
                Colors.background.copy(alpha = 0.94f).compositeOver(Colors.red),
            ).then(if (isMobile) Modifier.fillMaxWidth() else Modifier),
        horizontalAlignment = if (isMobile) Alignment.CenterHorizontally else Alignment.Start,
    ) {
        FlowRow(
            modifier =
                Modifier
                    .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(7.dp),
            verticalArrangement = Arrangement.spacedBy(7.dp),
        ) {
            if (isMobile) {
                TextTechnology(Modifier.fillMaxWidth().padding(vertical = 10.dp))
            } else {
                TechnologyHeader()
            }
            TechnologyKotlin()
            TechnologyJava()
            TechnologyCompose()
            TechnologyDagger()
            TechnologyCleanArchitecture()
            TechnologyTDD()
            TechnologyKMP()
        }
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
private fun TextTechnology(modifier: Modifier) {
    Text(
        modifier = modifier,
        text = "My technologies:",
        style = MaterialTheme.typography.bodyMedium,
    )
}

@Composable
private fun TechnologyHeader() {
    Technology {
        TextTechnology(Modifier.align(Alignment.TopStart))
    }
}

@Composable
private fun TechnologyKotlin() {
    Technology(
        modifierIcon =
            Modifier
                .padding(start = 15.dp, top = 14.dp),
        technology = TechnologiesEnum.Kotlin,
        experience = "${currentYear - 2020} years",
    )
}

@Composable
private fun TechnologyJava() {
    Technology(
        modifierIcon =
            Modifier
                .padding(start = 15.dp, top = 10.dp),
        technology = TechnologiesEnum.Java,
        experience = "${currentYear - 2020} years",
    )
}

@Composable
private fun TechnologyCompose() {
    Technology(
        modifierIcon =
            Modifier
                .padding(start = 13.dp, top = 10.dp),
        technology = TechnologiesEnum.JetpackCompose,
        experience = "${currentYear - 2022} years",
    )
}

@Composable
private fun TechnologyDagger() {
    Technology(
        modifierIcon =
            Modifier
                .padding(start = 12.dp, top = 10.dp),
        technology = TechnologiesEnum.Dagger,
        experience = "${currentYear - 2020} years",
    )
}

@Composable
private fun TechnologyCleanArchitecture() {
    Technology(
        modifierIcon =
            Modifier
                .padding(start = 13.dp, top = 10.dp),
        technology = TechnologiesEnum.CleanArchitecture,
        experience = "${currentYear - 2020} years",
    )
}

@Composable
private fun TechnologyTDD() {
    Technology(
        modifierIcon =
            Modifier
                .padding(start = 13.dp, top = 10.dp),
        technology = TechnologiesEnum.TDD,
        experience = "${currentYear - 2020} years",
    )
}

@Composable
private fun TechnologyKMP() {
    Technology(
        modifierIcon =
            Modifier
                .padding(start = 13.dp, top = 10.dp),
        technology = TechnologiesEnum.KMP,
        experience = "${currentYear - 2022} years",
    )
}

@Composable
private fun Technology(
    modifierIcon: Modifier,
    technology: TechnologiesEnum,
    experience: String,
) {
    Technology(
        modifier =
            Modifier
                .clip(MaterialTheme.shapes.medium)
                .border(1.dp, Colors.primary.copy(alpha = 0.04f), MaterialTheme.shapes.medium)
                .background(Colors.primary.copy(alpha = 0.02f)),
    ) {
        Icon(
            modifier = modifierIcon,
            imageVector = technology.imageVector,
            contentDescription = null,
        )
        Column(modifier = Modifier.align(Alignment.BottomStart).padding(horizontal = 15.dp, vertical = 13.dp)) {
            Text(
                text = technology.text,
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

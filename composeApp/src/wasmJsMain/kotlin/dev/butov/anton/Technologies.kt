package dev.butov.anton

import androidx.compose.ui.graphics.vector.ImageVector
import dev.butov.anton.myiconpack.*

enum class TechnologiesEnum(imageVector: ImageVector, name: String) {
    Kotlin(AntonIcons.Kotlin, "Kotlin"),
    Java(AntonIcons.Java, "Java"),
    JetpackCompose(AntonIcons.Compose, "Jetpack Compose"),
    Dagger(AntonIcons.Google, "Dagger"),
    DaggerDsl(AntonIcons.DaggerDsl, "Dagger DSL"),
    CleanArchitecture(AntonIcons.Android, "Clean Architecture"),
    TDD(AntonIcons.Android, "TDD"),
    KMP(AntonIcons.Kotlin, "Kotlin Multiplatform"),
    MVI(AntonIcons.Scroll, "MVI"),
    KTOR(AntonIcons.Kotlin, "Ktor"),
    WEBRTC(AntonIcons.Google, "WebRTC"),
    KotlinPoet(AntonIcons.Kotlin, "KotlinPoet"),
    KSP(AntonIcons.Kotlin, "KSP"),
}
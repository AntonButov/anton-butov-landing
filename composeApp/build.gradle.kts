import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.ktlint)
}

private val ktLintConfig: org.jlleitschuh.gradle.ktlint.KtlintExtension.() -> Unit = {
    debug.set(false)
    ignoreFailures.set(true)
    reporters {
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN)
    }
}

ktlint {
    ktLintConfig()
}

// tasks.named(":composeApp:wasmJsBrowserDevelopmentRun") {
//    dependsOn("check")
// }

gradle.projectsEvaluated {
    // The task is created in the composeApp module, so we reference it by path
    tasks.findByPath(":composeApp:wasmJsBrowserDevelopmentRun")?.apply {
        dependsOn("ktlintFormat")
    }
}

tasks.named("check") {
    dependsOn("ktlintFormat")
}

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        outputModuleName = "composeApp"
        browser {
            val rootDirPath = project.rootDir.path
            val projectDirPath = project.projectDir.path
            commonWebpackConfig {
                outputFileName = "composeApp.js"
                devServer =
                    (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                        static =
                            (static ?: mutableListOf()).apply {
                                // Serve sources to debug inside browser
                                add(rootDirPath)
                                add(projectDirPath)
                            }
                        // Оптимизация dev сервера
                        port = 8081
                        open = true
                    }
            }
            webpackTask {
                outputFileName = "composeApp.js"
            }
        }
        binaries.executable()

        // Optimize for production
        compilations.getByName("main") {
            kotlinOptions {
                freeCompilerArgs +=
                    listOf(
                        "-Xwasm-generate-wat",
                        "-Xwasm-use-new-exception-proposal",
                        // Оптимизация размера
                        "-Xwasm-generate-wat=false", // Отключаем WAT для продакшена
                        "-Xwasm-generate-dwarf=false", // Отключаем DWARF для продакшена
                    )
            }
        }
    }

    sourceSets {

        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(libs.coroutines.core)
            implementation(libs.ktor.client.core)
            implementation(libs.kotlinx.datetime)
        }
        wasmJsMain.dependencies {
            implementation(libs.ktor.client.js)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
            implementation(libs.coroutines.core)
            implementation(libs.ktor.client.mock)
            implementation(libs.coroutines.test)
        }
    }
}

package dev.butov.anton

object AppVersion {
    const val VERSION = "1.0.0"
    const val VERSION_CODE = 1
    const val BUILD_DATE = "2024-12-19"

    fun getFullVersion(): String = "v$VERSION (build $VERSION_CODE)"

    fun getVersionInfo(): String =
        """
        Anton Butov Landing
        Version: $VERSION
        Build: $VERSION_CODE
        Date: $BUILD_DATE
        """.trimIndent()
}

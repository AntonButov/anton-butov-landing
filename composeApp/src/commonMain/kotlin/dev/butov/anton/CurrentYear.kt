package dev.butov.anton

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

val currentYear: Int =
    Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).year

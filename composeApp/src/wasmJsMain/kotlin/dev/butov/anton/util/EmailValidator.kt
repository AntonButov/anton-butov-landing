package dev.butov.anton.util

private val EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$".toRegex()

/**
 * Validate email address format.
 *
 * @return true if the email looks valid according to a simple regex.
 */
fun isValidEmail(email: String): Boolean {
    return EMAIL_REGEX.matches(email)
}

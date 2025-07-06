package dev.butov.anton.util

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class EmailValidatorTest {
    @Test
    fun validEmailReturnsTrue() {
        assertTrue(isValidEmail("user@example.com"))
    }

    @Test
    fun invalidEmailReturnsFalse() {
        val invalidEmails = listOf(
            "plainaddress",
            "missing-at.com",
            "user@.com",
            "user@com",
            "user@domain..com"
        )
        for (email in invalidEmails) {
            assertFalse(isValidEmail(email), "Expected '$email' to be invalid")
        }
    }
}

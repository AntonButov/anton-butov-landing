package dev.butov.anton.subscreens.sendMessage

import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.request.forms.FormDataContent
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SendMessageRepositoryTest {
    @Test
    fun `send posts form data`() =
        runTest {
            var capturedBody: Any? = null
            var capturedAccept: String? = null
            val engine =
                MockEngine { request ->
                    capturedBody = request.body
                    capturedAccept = request.headers["Accept"]
                    respond("", HttpStatusCode.Accepted)
                }
            val client = HttpClient(engine)
            val repo = FormspreeSendMessageRepository("https://formspree.io/f/test", client)

            repo.send("john", "a@b.c", "hello")

            assertTrue(capturedBody is FormDataContent)
            val parameters = (capturedBody as FormDataContent).formData
            assertEquals(listOf("john"), parameters.getAll("name"))
            assertEquals(listOf("a@b.c"), parameters.getAll("email"))
            assertEquals(listOf("hello"), parameters.getAll("message"))
            assertEquals("application/json", capturedAccept)
        }
}

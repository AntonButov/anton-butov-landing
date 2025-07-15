package dev.butov.anton.subscreens.sendMessage

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.js.Js
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.Parameters

interface SendMessageRepository {
    suspend fun send(
        name: String,
        email: String,
        message: String,
    )
}

class FormspreeSendMessageRepository(
    private val endpoint: String = "https://formspree.io/f/mdkdngnn",
    private val client: HttpClient = HttpClient(Js),
) : SendMessageRepository {
    override suspend fun send(
        name: String,
        email: String,
        message: String,
    ) {
        client.post(endpoint) {
            setBody(
                FormDataContent(
                    Parameters.build {
                        append("name", name)
                        append("email", email)
                        append("message", message)
                    },
                ),
            )
        }.body<Unit>()
    }
}

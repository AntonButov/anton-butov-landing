package dev.butov.anton.subscreens.sendMessage

import io.ktor.client.HttpClient
import io.ktor.client.engine.js.Js
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.HttpHeaders
import io.ktor.http.Parameters

interface SendMessageRepository {
    suspend fun send(
        name: String,
        email: String,
        message: String,
    ): NetResult
}

class FormspreeSendMessageRepository(
    private val endpoint: String = "https://formspree.io/f/mdkdngnn",
    private val client: HttpClient = HttpClient(Js),
) : SendMessageRepository {
    override suspend fun send(
        name: String,
        email: String,
        message: String,
    ): NetResult {
        val resultCode =
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
                header(HttpHeaders.Accept, "application/json")
            }.status.value
        return when {
            resultCode == 422 -> NetResult.WrongEmail
            resultCode > 400 -> NetResult.UnkownError
            else -> NetResult.Success
        }
    }
}

enum class NetResult {
    Success,
    WrongEmail,
    UnkownError,
}

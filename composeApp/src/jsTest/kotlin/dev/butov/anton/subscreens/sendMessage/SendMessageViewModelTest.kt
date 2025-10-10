package dev.butov.anton.subscreens.sendMessage

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SendMessageViewModelTest {
    @Test
    fun `initial state is empty edit`() {
        val viewModel = SendMessageViewModel()
        assertEquals(SendMessageState.Edit("", "", ""), viewModel.state)
    }

    @Test
    fun `name change updates state`() {
        val viewModel = SendMessageViewModel()
        viewModel.onNameChange("John")
        assertEquals("John", viewModel.name)
        assertEquals(SendMessageState.Edit("John", "", ""), viewModel.state)
    }

    @Test
    fun `email change updates state`() {
        val viewModel = SendMessageViewModel()
        viewModel.onEmailChange("e@ma.il")
        assertEquals("e@ma.il", viewModel.email)
        assertEquals(SendMessageState.Edit("", "e@ma.il", ""), viewModel.state)
    }

    @Test
    fun `message change updates state`() {
        val viewModel = SendMessageViewModel()
        viewModel.onMessageChange("hello")
        assertEquals("hello", viewModel.message)
        assertEquals(SendMessageState.Edit("", "", "hello"), viewModel.state)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `send success changes state to Ok`() =
        runTest {
            val repo =
                object : SendMessageRepository {
                    override suspend fun send(
                        name: String,
                        email: String,
                        message: String,
                    ): NetResult = NetResult.Success
                }
            val viewModel = SendMessageViewModel(repo)
            viewModel.onNameChange("n")
            viewModel.onEmailChange("e")
            viewModel.onMessageChange("m")

            viewModel.send()
            advanceUntilIdle()

            assertEquals(SendMessageState.Ok, viewModel.state)
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `send failure sets error`() =
        runTest {
            val repo =
                object : SendMessageRepository {
                    override suspend fun send(
                        name: String,
                        email: String,
                        message: String,
                    ): NetResult {
                        throw RuntimeException()
                    }
                }
            val viewModel = SendMessageViewModel(repo)
            viewModel.onEmailChange("test@test.com")
            viewModel.onMessageChange("not emtpy meesage")
            viewModel.send()
            advanceUntilIdle()

            assertTrue { viewModel.state is SendMessageState.UnknounError }
        }

    @Test
    fun `when message is empty should state message error`() =
        runTest {
            val repo =
                object : SendMessageRepository {
                    override suspend fun send(
                        name: String,
                        email: String,
                        message: String,
                    ): NetResult {
                        error("Should not invoke")
                    }
                }

            val viewModel = SendMessageViewModel(repo)

            viewModel.send()
            assertEquals(Error.Email, viewModel.error)
            viewModel.onEmailChange("e@mail.com")
            assertEquals(null, viewModel.error)
            viewModel.send()
            assertEquals(Error.Message, viewModel.error)
            viewModel.onMessageChange("message")
            assertEquals(null, viewModel.error)
        }
}

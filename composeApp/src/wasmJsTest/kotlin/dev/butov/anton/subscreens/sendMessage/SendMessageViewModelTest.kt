package dev.butov.anton.subscreens.sendMessage

import kotlin.test.Test
import kotlin.test.assertEquals

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
}

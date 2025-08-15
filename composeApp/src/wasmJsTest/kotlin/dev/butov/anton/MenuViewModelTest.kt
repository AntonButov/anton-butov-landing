package dev.butov.anton;

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MenuViewModelTest {
    @Test
    fun initialStateClosed() {
        val viewModel = MenuViewModel()
        assertFalse(viewModel.isMenuOpen)
    }

    @Test
    fun toggleChangesState() {
        val viewModel = MenuViewModel()
        viewModel.onHamburgerClick()
        assertTrue(viewModel.isMenuOpen)
        viewModel.onHamburgerClick()
        assertFalse(viewModel.isMenuOpen)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun onMenuItemClickEmitsIndexCloses() = runTest {
        val viewModel = MenuViewModel()
        val result = async { viewModel.scrollRequests.first() }
        viewModel.onMenuItemClick(MenuItem.PROJECTS)
        assertEquals(MenuItem.PROJECTS.index, result.await())
        assertFalse(viewModel.isMenuOpen)
    }
}

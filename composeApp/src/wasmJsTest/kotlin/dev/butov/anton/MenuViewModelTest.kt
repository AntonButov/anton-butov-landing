package dev.butov.anton

import dev.butov.anton.subscreens.burger.MenuItem
import dev.butov.anton.subscreens.burger.MenuViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
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
    fun onMenuItemClickEmitsIndexCloses() =
        runTest {
            val viewModel = MenuViewModel()
            viewModel.onMenuItemClick(MenuItem.PROJECTS)
            val result = viewModel.scrollRequests
            assertEquals(MenuItem.PROJECTS.index, result)
            assertFalse(viewModel.isMenuOpen)
        }
}

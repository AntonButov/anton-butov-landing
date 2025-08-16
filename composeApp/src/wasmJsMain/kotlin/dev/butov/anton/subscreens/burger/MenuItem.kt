package dev.butov.anton.subscreens.burger

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

enum class MenuItem(val title: String, val index: Int) {
    HEADER("Home", 0),
    TECHNOLOGIES("Technologies", 1),
    PROJECTS("Porjects", 2),
    CONTACT("Contact", 3),
}

class MenuViewModel : ViewModel() {
    var isMenuOpen by mutableStateOf(false)
        private set

    var scrollRequests by mutableStateOf(0)

    fun onHamburgerClick() {
        isMenuOpen = !isMenuOpen
    }

    fun onDismissMenu() {
        isMenuOpen = false
    }

    fun onMenuItemClick(item: MenuItem) {
        isMenuOpen = false
        scrollRequests = item.index
    }
}

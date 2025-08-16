package dev.butov.anton.subscreens.burger

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

enum class MenuItem(val title: String, val index: Int) {
    HEADER("Home", 0),
    TECHNOLOGIES("Technologies", 1),
    PROJECTS("Contact", 2),
    CONTACT("Contact", 3),
}

class MenuViewModel : ViewModel() {
    var isMenuOpen by mutableStateOf(false)
        private set

    private val _scrollRequests = MutableSharedFlow<Int>()
    val scrollRequests = _scrollRequests.asSharedFlow()

    fun onHamburgerClick() {
        isMenuOpen = !isMenuOpen
    }

    fun onDismissMenu() {
        isMenuOpen = false
    }

    fun onMenuItemClick(item: MenuItem) {
        isMenuOpen = false
        viewModelScope.launch { _scrollRequests.emit(item.index) }
    }
}

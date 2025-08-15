package dev.butov.anton.subscreens.burger

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Menu(
    items: List<String>,
    selectedIndex: Int,
    onItemClick: (Int) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    // затемнение фона и клик вне меню закрывает его
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xCC000000))
            .clickable(indication = null, interactionSource = remember { MutableInteractionSource() }) {
                onClose()
            }
    ) {
        // сама карточка меню
        Surface(
            modifier = modifier
                .padding(start = 8.dp, top = 8.dp) // расположение у левого верхнего края
                .widthIn(min = 180.dp)
                .clickable(enabled = false) {},     // блокируем "протекание" клика
            shape = RoundedCornerShape(12.dp),
            color = Color.White,
            tonalElevation = 6.dp,
            shadowElevation = 6.dp
        ) {
            Column(modifier = Modifier.padding(vertical = 8.dp)) {

                items.forEachIndexed { index, title ->
                    val isSelected = index == selectedIndex
                    Text(
                        text = title,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 10.dp)
                            .clickable { onItemClick(index) },
                        style = MaterialTheme.typography.bodyMedium,
                        color = if (isSelected) Color(0xFFD12D2D) else Color(0xFF1A1A1A)
                    )
                }

                Spacer(Modifier.height(4.dp))
            }
        }
    }
}

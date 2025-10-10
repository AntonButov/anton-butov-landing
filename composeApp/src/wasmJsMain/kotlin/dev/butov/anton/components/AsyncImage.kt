package dev.butov.anton.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

/**
 * AsyncImage component with lazy loading simulation
 * Provides better UX by showing loading state before displaying image
 */
@OptIn(ExperimentalResourceApi::class)
@Composable
fun AsyncImage(
    resource: DrawableResource,
    contentDescription: String? = null,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
    loadingPlaceholder: @Composable () -> Unit = {
        DefaultLoadingPlaceholder(modifier = modifier)
    },
    errorPlaceholder: @Composable () -> Unit = {
        DefaultErrorPlaceholder(modifier = modifier)
    },
) {
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(resource) {
        // Simulate async loading with a small delay for better UX
        delay(50)
        isLoading = false
    }

    if (isLoading) {
        loadingPlaceholder()
    } else {
        // Load the resource directly (will throw if resource doesn't exist)
        Image(
            painter = painterResource(resource),
            contentDescription = contentDescription,
            modifier = modifier,
            contentScale = contentScale,
        )
    }
}

/**
 * AsyncImage for static image URLs (placeholder implementation)
 */
@Composable
fun AsyncImage(
    imageUrl: String,
    contentDescription: String? = null,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
    loadingPlaceholder: @Composable () -> Unit = {
        DefaultLoadingPlaceholder(modifier = modifier)
    },
    errorPlaceholder: @Composable () -> Unit = {
        DefaultErrorPlaceholder(modifier = modifier)
    },
) {
    // Placeholder implementation for URL images
    // In a real implementation, you would load the image from URL
    Box(
        modifier =
            modifier
                .background(Color.Gray.copy(alpha = 0.3f))
                .clip(MaterialTheme.shapes.medium),
        contentAlignment = Alignment.Center,
    ) {
        androidx.compose.material3.Text(
            text = "Image: ${imageUrl.take(20)}...",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray,
        )
    }
}

@Composable
private fun DefaultLoadingPlaceholder(modifier: Modifier = Modifier) {
    Box(
        modifier =
            modifier
                .background(Color.Gray.copy(alpha = 0.1f))
                .clip(MaterialTheme.shapes.medium),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(24.dp),
            color = MaterialTheme.colorScheme.primary,
            strokeWidth = 2.dp,
        )
    }
}

@Composable
private fun DefaultErrorPlaceholder(modifier: Modifier = Modifier) {
    Box(
        modifier =
            modifier
                .background(Color.Red.copy(alpha = 0.1f))
                .clip(MaterialTheme.shapes.medium),
        contentAlignment = Alignment.Center,
    ) {
        androidx.compose.material3.Text(
            text = "Failed to load",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Red,
        )
    }
}

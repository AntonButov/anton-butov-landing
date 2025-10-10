package dev.butov.anton.components

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
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter
import coil3.compose.SubcomposeAsyncImage
import coil3.compose.rememberAsyncImagePainter
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.DrawableResource

/**
 * AsyncImage component using Coil for optimal image loading
 * Provides better UX with automatic caching and optimization
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
    }
) {
    SubcomposeAsyncImage(
        model = resource,
        contentDescription = contentDescription,
        modifier = modifier,
        contentScale = contentScale,
        loading = {
            loadingPlaceholder()
        },
        error = {
            errorPlaceholder()
        }
    )
}

/**
 * AsyncImage for static image URLs with Coil caching
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
    }
) {
    SubcomposeAsyncImage(
        model = imageUrl,
        contentDescription = contentDescription,
        modifier = modifier,
        contentScale = contentScale,
        loading = {
            loadingPlaceholder()
        },
        error = {
            errorPlaceholder()
        }
    )
}

@Composable
private fun DefaultLoadingPlaceholder(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(Color.Gray.copy(alpha = 0.1f))
            .clip(MaterialTheme.shapes.medium),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(24.dp),
            color = MaterialTheme.colorScheme.primary,
            strokeWidth = 2.dp
        )
    }
}

@Composable
private fun DefaultErrorPlaceholder(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(Color.Red.copy(alpha = 0.1f))
            .clip(MaterialTheme.shapes.medium),
        contentAlignment = Alignment.Center
    ) {
        androidx.compose.material3.Text(
            text = "Failed to load",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Red
        )
    }
}

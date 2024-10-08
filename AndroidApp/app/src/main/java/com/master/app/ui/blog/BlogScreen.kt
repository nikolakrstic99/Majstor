package com.master.app.ui.blog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.master.app.R
import com.master.app.ui.component.Base64Image
import com.master.app.ui.component.ClippedIconButton
import com.master.app.ui.state.BlogViewModel
import com.master.app.ui.theme.AndroidAppTheme

@Composable
fun BlogScreen(
    navigateOnBlogDeleted: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: BlogViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    if (uiState.blog != null) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.Start,
            modifier = modifier
                .padding(10.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = uiState.blog!!.title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Divider()
            LazyRow {
                items(
                    items = uiState.blog!!.images
                ) {
                    Base64Image(
                        base64Str = it.data,
                        modifier = Modifier
                            .padding(5.dp)
                            .size(100.dp)
                            .clip(MaterialTheme.shapes.medium)
                    )
                }
            }
            if (uiState.blog!!.images.isEmpty()) {
                Text(
                    text = "No images attached",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
            Divider()
            Text(
                text = uiState.blog!!.text,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
            Divider()
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "${uiState.blog!!.author.firstName} ${uiState.blog!!.author.lastName}",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = uiState.blog!!.createdAt,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.tertiary
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            ClippedIconButton(
                text = "Delete blog",
                onClick = {
                    viewModel.deleteBlog()
                    navigateOnBlogDeleted()
                },
                background = MaterialTheme.colorScheme.errorContainer,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BlogScreenPreview() {
    AndroidAppTheme {
        BlogScreen({})
    }
}

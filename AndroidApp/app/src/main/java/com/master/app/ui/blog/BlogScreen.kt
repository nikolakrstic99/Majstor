package com.master.app.ui.blog

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.master.app.R
import com.master.app.ui.state.BlogViewModel
import com.master.app.ui.theme.AndroidAppTheme
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun BlogScreen(
    modifier: Modifier = Modifier,
    viewModel: BlogViewModel = viewModel()
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.End,
        modifier = modifier
            .padding(10.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = viewModel.blog.title,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Divider()
        LazyRow {
            items(
                items = listOf<String>()
            ) {
//                AsyncImage(
//                    model = it,
//                    contentDescription = "Blog picture",
//                    modifier = Modifier
//                        .padding(10.dp)
//                        .size(200.dp)
//                )
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Preview image",
                    modifier = Modifier
                        .padding(5.dp)
                        .size(100.dp)
                        .clip(MaterialTheme.shapes.medium)
                )
            }
        }
        Divider()
        Text(
            text = viewModel.blog.text,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        Divider()
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "${viewModel.blog.author.firstName} ${viewModel.blog.author.lastName}",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.secondary
            )
            Text(
                text = viewModel.blog.createdAt,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.tertiary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BlogScreenPreview() {
    AndroidAppTheme {
        BlogScreen()
    }
}

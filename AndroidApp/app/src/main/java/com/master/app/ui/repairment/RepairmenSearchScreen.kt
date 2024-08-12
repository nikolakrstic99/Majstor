package com.master.app.ui.repairment

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.master.app.ui.component.ClippedIconButton
import com.master.app.ui.component.SearchBar
import com.master.app.ui.state.RepairmenSearchViewModel
import com.master.app.ui.theme.AndroidAppTheme
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepairmenSearchScreen(
    onRepairmanClicked: (Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: RepairmenSearchViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    var showFilterMenu by remember { mutableStateOf(false)}

    Column(
        modifier = modifier
    ){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(20.dp)
        ) {
            Text(
                text = uiState.topLevelCategory?: "",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .horizontalScroll(rememberScrollState())
        ) {
            IconButton(onClick = { showFilterMenu = !showFilterMenu }) {
                Icon(
                    imageVector = Icons.Filled.AddCircle,
                    contentDescription = "Add category filters"
                )
            }
            if (uiState.categoriesSelected == null || uiState.categoriesSelected!!.isEmpty()) {
                Text(
                    text = "No filters applied",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.LightGray
                )
            }
            uiState.categoriesSelected?.toList()?.forEach { selectedFilter ->
                ClippedIconButton(
                    text = selectedFilter,
                    onClick = { viewModel.categoryFilterRemoved(selectedFilter) }
                )
            }
        }
        AnimatedVisibility(showFilterMenu) {
            FilterRepairmen(
                categories = uiState.categoriesNotSelected?.toList() ?: listOf(),
                onCategoryClicked = {
                    showFilterMenu = false
                    viewModel.categoryFilterAdded(it)
                },
                Modifier
                    .clip(MaterialTheme.shapes.medium)
                    .background(MaterialTheme.colorScheme.primaryContainer)
            )
        }
        SearchBar(
            onValueChanged = viewModel::onSearchInputChanged,
            placeholder = "Search repairmen"
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(onClick = viewModel::onSortByNameClicked) {
                    Icon(
                        imageVector = if (uiState.sortByNameAsc) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                        contentDescription = "Sort by name"
                    )
                }
                Text(
                    text = "Name",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Rating",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                IconButton(onClick = viewModel::onSortByRatingClicked) {
                    Icon(
                        imageVector = if (uiState.sortByRatingAsc) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                        contentDescription = "Sort by rating"
                    )
                }
            }
        }
        RepairmenList(
            repairmen = uiState.repairmen ?: listOf(),
            pageSize = if (showFilterMenu) 7 else 8,
            onRepairmanClicked = onRepairmanClicked
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RepairmenSearchScreenPreview() {
    AndroidAppTheme {
        RepairmenSearchScreen({})
    }
}
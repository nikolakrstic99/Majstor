package com.master.app.ui.repairment

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.master.app.ui.state.RepairmentCategoriesViewModel
import com.master.app.ui.theme.AndroidAppTheme

@Composable
fun RepairmentCategoryList(
    onCategoryClicked: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: RepairmentCategoriesViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 150.dp),
        modifier = modifier
    ) {
        items(uiState.topLevelCategories?: listOf()) {
            RepairmentCategoryPreview(
                topLevelCategory = it,
                iconDrawableId = viewModel.getTopLevelCategoryIcon(it),
                numberOfRepairmen = uiState.repairmenPerCategory?.get(it) ?: 0,
                modifier = Modifier.clickable(onClick = {
                    onCategoryClicked(it)
                })
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RepairmentCategoryListPreview() {
    AndroidAppTheme {
        RepairmentCategoryList({})
    }
}
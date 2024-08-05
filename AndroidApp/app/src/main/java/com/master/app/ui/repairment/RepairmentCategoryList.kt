package com.master.app.ui.repairment

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.master.app.ui.state.RepairmentCategoriesViewModel
import com.master.app.ui.theme.AndroidAppTheme

@Composable
fun RepairmentCategoryList(
    onCategoryClicked: (Int) -> Unit,
    modifier: Modifier = Modifier,
    repairmentCategoriesViewModel: RepairmentCategoriesViewModel = viewModel(),
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 150.dp),
        modifier = modifier
    ) {
        items(repairmentCategoriesViewModel.repairmentCategories) {
            RepairmentCategoryPreview(
                it,
                modifier = Modifier.clickable(onClick = {
                    onCategoryClicked(it.id)
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
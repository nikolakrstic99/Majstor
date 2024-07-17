package com.master.app.ui.repairment

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.master.app.data.model.RepairmentCategory
import com.master.app.ui.theme.AndroidAppTheme

@Composable
fun RepairmentCategoryList(
    repairmentCategories: List<RepairmentCategory>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 150.dp)
    ) {
        items(repairmentCategories) {
            RepairmentCategoryPreview(it)
        }
    }
}

val exampleCategoryList = listOf(
    RepairmentCategory(
        1,
        "Gradjevinski radovi",
        495,
        "picture"
    ),
    RepairmentCategory(
        2,
        "Elektronika",
        25,
        "picture"
    ),
    RepairmentCategory(
        3,
        "Odrzavanje",
        105,
        "picture"
    ),
    RepairmentCategory(
        4,
        "Cevne instalacije",
        8,
        "picture"
    ),
    RepairmentCategory(
        5,
        "Nekategorizovano",
        2,
        "picture"
    )
)

@Preview(showBackground = true)
@Composable
fun RepairmentCategoryListPreview() {
    AndroidAppTheme {
        RepairmentCategoryList(
            repairmentCategories = exampleCategoryList
        )
    }
}
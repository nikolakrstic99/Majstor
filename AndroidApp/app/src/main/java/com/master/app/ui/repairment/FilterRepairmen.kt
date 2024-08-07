package com.master.app.ui.repairment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.master.app.ui.model.RepairmentCategory
import com.master.app.ui.component.ClippedIconButton
import com.master.app.ui.theme.AndroidAppTheme

@Composable
fun FilterRepairmen(
    categories: List<RepairmentCategory>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        items(categories) { category ->
            ClippedIconButton(
                text = category.name,
                onClick = { /*TODO*/ }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FilterRepairmenPreview() {
    AndroidAppTheme {
        FilterRepairmen(
            listOf(
                RepairmentCategory(
                    1,
                    "Keramicar",
                    136,
                    "pictureURL"
                ),
                RepairmentCategory(
                    2,
                    "Moler",
                    26,
                    "pictureURL"
                ),
                RepairmentCategory(
                    3,
                    "Parketar",
                    8,
                    "pictureURL"
                ),
                RepairmentCategory(
                    1,
                    "Keramicar",
                    136,
                    "pictureURL"
                ),
                RepairmentCategory(
                    2,
                    "Moler",
                    26,
                    "pictureURL"
                ),
                RepairmentCategory(
                    3,
                    "Parketar",
                    8,
                    "pictureURL"
                )
            )
        )
    }
}
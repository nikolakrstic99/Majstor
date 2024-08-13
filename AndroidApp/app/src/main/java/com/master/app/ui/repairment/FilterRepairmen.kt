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
import com.master.app.ui.component.ClippedIconButton
import com.master.app.ui.theme.AndroidAppTheme

@Composable
fun FilterRepairmen(
    categories: List<String>,
    onCategoryClicked: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        items(categories) {
            ClippedIconButton(
                text = it,
                onClick = { onCategoryClicked(it) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FilterRepairmenPreview() {
    AndroidAppTheme {
        FilterRepairmen(
            listOf("Keramicar", "Parketar"),
            {_ -> }
        )
    }
}
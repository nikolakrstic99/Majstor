package com.master.app.ui.repairment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.master.app.data.model.Repairman
import com.master.app.ui.theme.AndroidAppTheme
import com.master.app.utils.paginate

@Composable
fun RepairmenList(
    repairmen: List<Repairman>,
    pageSize: Int,
    modifier: Modifier = Modifier
) {
    var currentPage by remember { mutableIntStateOf(1) }
    val paginatedItems = paginate(repairmen, currentPage, pageSize)
    val nextPageEnabled = currentPage * pageSize < repairmen.size;

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
        ) {
            items(paginatedItems) { repairman ->
                RepairmanPreview(
                    repairman = repairman,
                    Modifier.padding(2.dp)
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            IconButton(
                onClick = { if (currentPage > 1) currentPage-- },
                enabled = currentPage > 1
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Previous page",
                )
            }
            Text(
                text = currentPage.toString(),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.secondary
            )
            IconButton(
                onClick = { if (nextPageEnabled) currentPage++ },
                enabled = nextPageEnabled
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = "Next page"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RepairmenListPreview() {
    AndroidAppTheme {
        RepairmenList(
            listOf(
                Repairman(
                    1,
                    "Milojko Pantic",
                    8.3723725,
                    listOf("Moler", "Parketar")
                ),
                Repairman(
                    2,
                    "Petar Vojinovic",
                    7.2,
                    listOf("Parketar")
                ),
                Repairman(
                    3,
                    "David Zlatkovic",
                    10.0,
                    listOf("Moler")
                ),
                Repairman(
                    1,
                    "Milojko Pantic",
                    8.3723725,
                    listOf("Moler", "Parketar")
                ),
                Repairman(
                    2,
                    "Petar Vojinovic",
                    7.2,
                    listOf("Parketar")
                ),
                Repairman(
                    3,
                    "David Zlatkovic",
                    10.0,
                    listOf("Moler")
                ),
                Repairman(
                    1,
                    "Milojko Pantic",
                    8.3723725,
                    listOf("Moler", "Parketar")
                ),
                Repairman(
                    2,
                    "Petar Vojinovic",
                    7.2,
                    listOf("Parketar")
                ),
                Repairman(
                    3,
                    "David Zlatkovic",
                    10.0,
                    listOf("Moler")
                ),
                Repairman(
                    1,
                    "Milojko Pantic",
                    8.3723725,
                    listOf("Moler", "Parketar")
                ),
                Repairman(
                    2,
                    "Petar Vojinovic",
                    7.2,
                    listOf("Parketar")
                ),
                Repairman(
                    3,
                    "David Zlatkovic",
                    10.0,
                    listOf("Moler")
                )
            ),
            5
        )
    }
}
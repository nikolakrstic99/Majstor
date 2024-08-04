package com.master.app.ui.repairment

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.unit.max
import com.master.app.data.model.Repairman
import com.master.app.data.model.RepairmentCategory
import com.master.app.ui.component.ClippedIconButton
import com.master.app.ui.component.SearchBar
import com.master.app.ui.theme.AndroidAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepairmenSearchScreen(
    topLevelCategory: RepairmentCategory,
    repairmen: List<Repairman>,
    categories: List<RepairmentCategory>,
    modifier: Modifier = Modifier
) {
    val selectedFilters = listOf("Moler", "Keramicar", "Gradjevinski limar", "Tesar", "Secenje i Busenje")
    var showFilterMenu by remember { mutableStateOf(false)}

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        text = topLevelCategory.name,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Go back"
                        )
                    }
                },
                scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
            )
        },
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .horizontalScroll(rememberScrollState())
            ) {
                IconButton(onClick = { showFilterMenu = true }) {
                    Icon(
                        imageVector = Icons.Filled.AddCircle,
                        contentDescription = "Add category filters"
                    )
                }
                if (selectedFilters.isEmpty()) {
                    Text(
                        text = "No filters applied",
                        style = MaterialTheme.typography.headlineSmall,
                        color = Color.LightGray
                    )
                }
                selectedFilters.forEach { selectedFilter ->
                    ClippedIconButton(
                        text = selectedFilter,
                        onClick = { /*TODO*/ }
                    )
                }
            }
            AnimatedVisibility(showFilterMenu) {
                FilterRepairmen(
                    categories = categories,
                    Modifier
                        .clip(MaterialTheme.shapes.medium)
                        .background(MaterialTheme.colorScheme.primaryContainer)
                )
            }
            SearchBar(
                onValueChanged = {},
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
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowDown,
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
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowDown,
                            contentDescription = "Sort by rating"
                        )
                    }
                }
            }
            RepairmenList(
                repairmen = repairmen,
                pageSize = 8
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RepairmenSearchScreenPreview() {
    AndroidAppTheme {
        RepairmenSearchScreen(
            RepairmentCategory(
                1,
                "Gradjevinski radovi",
                136,
                "pictureURL"
            ),
            listOf(
                Repairman(
                    1,
                    "Milojko Pantic",
                    8.3723725,
                    "0621482242",
                    listOf("Moler", "Parketar")
                ),
                Repairman(
                    2,
                    "Petar Vojinovic",
                    7.2,
                    "0621482242",
                    listOf("Parketar")
                ),
                Repairman(
                    3,
                    "David Zlatkovic",
                    10.0,
                    "0621482242",
                    listOf("Moler")
                ),
                Repairman(
                    1,
                    "Milojko Pantic",
                    8.3723725,
                    "0621482242",
                    listOf("Moler", "Parketar")
                ),
                Repairman(
                    2,
                    "Petar Vojinovic",
                    7.2,
                    "0621482242",
                    listOf("Parketar")
                ),
                Repairman(
                    3,
                    "David Zlatkovic",
                    10.0,
                    "0621482242",
                    listOf("Moler")
                ),
                Repairman(
                    1,
                    "Milojko Pantic",
                    8.3723725,
                    "0621482242",
                    listOf("Moler", "Parketar")
                ),
                Repairman(
                    2,
                    "Petar Vojinovic",
                    7.2,
                    "0621482242",
                    listOf("Parketar")
                ),
                Repairman(
                    3,
                    "David Zlatkovic",
                    10.0,
                    "0621482242",
                    listOf("Moler")
                ),
                Repairman(
                    1,
                    "Milojko Pantic",
                    8.3723725,
                    "0621482242",
                    listOf("Moler", "Parketar")
                ),
                Repairman(
                    2,
                    "Petar Vojinovic",
                    7.2,
                    "0621482242",
                    listOf("Parketar")
                ),
                Repairman(
                    3,
                    "David Zlatkovic",
                    10.0,
                    "0621482242",
                    listOf("Moler")
                ),
                Repairman(
                    1,
                    "Milojko Pantic",
                    8.3723725,
                    "0621482242",
                    listOf("Moler", "Parketar")
                ),
                Repairman(
                    2,
                    "Petar Vojinovic",
                    7.2,
                    "0621482242",
                    listOf("Parketar")
                ),
                Repairman(
                    3,
                    "David Zlatkovic",
                    10.0,
                    "0621482242",
                    listOf("Moler")
                ),
                Repairman(
                    1,
                    "Milojko Pantic",
                    8.3723725,
                    "0621482242",
                    listOf("Moler", "Parketar")
                ),
                Repairman(
                    2,
                    "Petar Vojinovic",
                    7.2,
                    "0621482242",
                    listOf("Parketar")
                ),
                Repairman(
                    3,
                    "David Zlatkovic",
                    10.0,
                    "0621482242",
                    listOf("Moler")
                )
            ),
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
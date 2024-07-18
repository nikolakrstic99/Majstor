package com.master.app.ui.repairment

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
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.master.app.data.model.Repairman
import com.master.app.data.model.RepairmentCategory
import com.master.app.ui.component.ClippedIconButton
import com.master.app.ui.theme.AndroidAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepairmenSearchScreen(
    repairmentCategory: RepairmentCategory,
    repairmen: List<Repairman>,
    modifier: Modifier = Modifier
) {
    val selectedFilters = listOf("Moler", "Keramicar", "Gradjevinski limar", "Tesar", "Secenje i Busenje")

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        text = repairmentCategory.name,
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
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search for repairmen"
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
            val scrollState = rememberScrollState()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .horizontalScroll(scrollState)
            ) {
                IconButton(onClick = { /* do something */ }) {
                    Icon(
                        imageVector = Icons.Filled.List,
                        contentDescription = "Search for repairmen"
                    )
                }
                selectedFilters.forEach { selectedFilter ->
                    ClippedIconButton(
                        text = selectedFilter,
                        onClick = { /*TODO*/ },
                        Modifier.size(width = 100.dp, height = 40.dp)
                    )
                }
            }
            LazyColumn {
                items(repairmen) { repairman ->
                    RepairmanPreview(
                        repairman = repairman,
                        Modifier.padding(2.dp)
                    )
                }
            }
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
            )
        )
    }
}
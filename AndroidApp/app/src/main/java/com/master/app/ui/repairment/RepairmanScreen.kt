package com.master.app.ui.repairment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.master.app.ui.component.CallButton
import com.master.app.ui.component.MessageButton
import com.master.app.ui.state.RepairmanViewModel
import com.master.app.ui.theme.AndroidAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepairmanScreen(
    modifier: Modifier = Modifier,
    viewModel: RepairmanViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    var selectedItem by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        text = "${uiState.repairman?.firstName} ${uiState.repairman?.lastName}",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    MessageButton(
                        phoneNumber = "0621482242",
                        Modifier.padding(10.dp)
                    )
                },
                actions = {
                    CallButton(
                        phoneNumber = "0621482242",
                        Modifier.padding(10.dp)
                    )
                },
                scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(),
                // Necessary due to scaffold inside a scaffold
                modifier = Modifier.padding(top = 65.dp)
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedItem == 0,
                    label = { Text(text = "Services") },
                    onClick = { selectedItem = 0 },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Build,
                            contentDescription = "Services icon"
                        )
                    }
                )
                NavigationBarItem(
                    selected = selectedItem == 1,
                    label = { Text(text = "Reviews") },
                    onClick = { selectedItem = 1 },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Email,
                            contentDescription = "Reviews icon"
                        )
                    }
                )
                NavigationBarItem(
                    selected = selectedItem == 2,
                    label = { Text(text = "Contact") },
                    onClick = { selectedItem = 2 },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = "Contact icon"
                        )
                    }
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(10.dp)
                .verticalScroll(rememberScrollState())
        ) {
            if (selectedItem == 0) {
                RepairmanServices(
                    providedServices = uiState.services ?: listOf()
                )
            }
            if (selectedItem == 1) {
                RepairmanReviewsScreenContent(
                    reviews = uiState.reviews ?: listOf(),
                    onSubmitReviewClicked = viewModel::addReview,
                    showButton = uiState.showReviewRepairmenButton
                )
            }
            if (selectedItem == 2) {
                RepairmanContactScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RepairmanScreenPreview() {
    AndroidAppTheme {
        RepairmanScreen()
    }
}
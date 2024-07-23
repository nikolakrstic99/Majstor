package com.master.app.ui.repairment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.master.app.data.model.Repairman
import com.master.app.data.model.Review
import com.master.app.ui.component.CallButton
import com.master.app.ui.theme.AndroidAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepairmanScreen(
    repairman: Repairman,
    modifier: Modifier = Modifier
) {
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
                        text = repairman.name,
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
                    CallButton(
                        phoneNumber = repairman.phoneNumber,
                        Modifier.padding(10.dp)
                    )
                },
                scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
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
        ) {
            if (selectedItem == 0) {
                RepairmanServices(
                    averageRating = 8.7,
                    providedServices = listOf("Postavljanje laminata", "Skidanje parketa", "Postavljanje parketa")
                )
            }
            if (selectedItem == 1) {
                RepairmanReviewsScreenContent(
                    reviews = listOf(
                        Review(
                            1,
                            "Andrej Jokic",
                            1,
                            2,
                            "Sasvim solidan majstor. Mogao bi malo brze da radi i manje da prica.",
                            "11.08.2024."
                        ),
                        Review(
                            2,
                            "Nikola Krstic",
                            1,
                            2,
                            "Sasvim solidan majstor. Mogao bi malo brze da radi i manje da prica. Sasvim solidan majstor. Mogao bi malo brze da radi i manje da prica. Sasvim solidan majstor. Mogao bi malo brze da radi i manje da prica.",
                            "08.02.2024."
                        ),
                        Review(
                            3,
                            "Sara Kolarevic",
                            1,
                            3,
                            "Volim da pricam Volim da pricamv Volim da pricam Volim da pricam. Volim da pricam Volim da pricamv Volim da pricam Volim da pricam. Volim da pricam Volim da pricamv Volim da pricam Volim da pricam. Volim da pricam Volim da pricamv Volim da pricam Volim da pricam. Volim da pricam Volim da pricamv Volim da pricam Volim da pricam.",
                            "11.12.2024."
                        )
                    ),
                    onSubmitReviewClicked = { /* TODO */ }
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
        RepairmanScreen(
            Repairman(
                1,
                "Milojko Pantic",
                8.3723725,
                "0621482242",
                listOf("Moler", "Parketar")
            )
        )
    }
}
package com.master.app.ui.repairment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.master.app.R
import com.master.app.data.model.Review
import com.master.app.ui.component.ClippedIconButton
import com.master.app.ui.theme.AndroidAppTheme

@Composable
fun RepairmanReviewsScreenContent(
    reviews: List<Review>,
    onSubmitReviewClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        RepairmanRatings(
            ratings = reviews.map { it.rating }
        )
        ReviewRepairmanButton(onSubmitReviewClicked)
        RepairmanReviews(
            reviews = reviews
        )
    }
}

@Composable
fun ReviewRepairmanButton(
    onSubmit: () -> Unit,
    modifier: Modifier = Modifier
) {
    var showSubmitReviewDialog by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .clip(MaterialTheme.shapes.small)
            .background(MaterialTheme.colorScheme.inverseOnSurface)
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Review repairman",
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = "Describe your experience with this repairman and help others.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.secondary,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )
        ClippedIconButton(
            text = "Review repairman",
            onClick = { showSubmitReviewDialog = true },
            Modifier.width(150.dp)
        )
        if (showSubmitReviewDialog) {
            ReviewRepairmanDialog(
                onConfirmation = {
                    run {
                        showSubmitReviewDialog = false
                        onSubmit()
                    }
                }
            )
        }
    }
}

@Composable
fun ReviewRepairmanDialog(
    onConfirmation: () -> Unit,
    modifier: Modifier = Modifier
) {
    val starSize = 25.dp

    var name by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }
    var rating by remember { mutableIntStateOf(0) }

    Dialog(onDismissRequest = { /*TODO*/ }) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = modifier
                .clip(MaterialTheme.shapes.small)
                .background(MaterialTheme.colorScheme.inverseOnSurface)
                .padding(15.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Submit review",
                style = MaterialTheme.typography.titleLarge
            )
            OutlinedTextField(
                value = name,
                onValueChange = { input -> name = input},
                placeholder = { Text(text = "Your name") },
                maxLines = 1,
                modifier = Modifier.background(MaterialTheme.colorScheme.background)
            )
            OutlinedTextField(
                value = text,
                onValueChange = { input -> text = input},
                placeholder = { Text(text = "Your name") },
                maxLines = 4,
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .height(150.dp)
            )

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                for (i in 1..5) {
                    if (i <= rating) {
                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = "Full Star",
                            tint = Color.Black,
                            modifier = Modifier
                                .size(starSize)
                                .clickable {
                                    rating = i
                                }
                        )
                    } else {
                        Image(
                            painter = painterResource(id = R.drawable.empty_star),
                            contentDescription = "Empty star",
                            modifier = Modifier
                                .size(starSize)
                                .clickable {
                                    rating = i
                                }
                        )
                    }
                }
            }
            if (rating > 0 && name.isNotBlank() && text.isNotBlank()) {
                ClippedIconButton(
                    text = "Submit",
                    onClick = onConfirmation
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun RepairmanReviewsScreenContentPreview() {
    AndroidAppTheme {
        RepairmanReviewsScreenContent(
            listOf(
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
            {}
        )
    }
}
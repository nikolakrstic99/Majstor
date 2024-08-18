package com.master.app.ui.repairment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
    onSubmitReviewClicked: (String, Int) -> Unit,
    showButton: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        // modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        RepairmanRatings(
            ratings = reviews.map { it.rating }
        )
        ReviewRepairmanButton(
            onSubmit = onSubmitReviewClicked,
            showButton = showButton
        )
        RepairmanReviews(
            reviews = reviews
        )
    }
}

@Composable
fun ReviewRepairmanButton(
    onSubmit: (String, Int) -> Unit,
    showButton: Boolean,
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
        if (showButton) {
            ClippedIconButton(
                text = "Review repairman",
                onClick = { showSubmitReviewDialog = true },
                Modifier.width(150.dp)
            )
        }
        else {
            Text(
                text = "You cannot review this repairman",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }

        if (showSubmitReviewDialog) {
            ReviewRepairmanDialog(
                onConfirmation = { text, rating ->
                    showSubmitReviewDialog = false
                    onSubmit(text, rating)
                },
                onDismiss = { showSubmitReviewDialog = false }
            )
        }
    }
}

@Composable
fun ReviewRepairmanDialog(
    onConfirmation: (String, Int) -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    val starSize = 25.dp

    var text by remember { mutableStateOf("") }
    var rating by remember { mutableIntStateOf(0) }

    Dialog(onDismissRequest = onDismiss) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = modifier
                .clip(MaterialTheme.shapes.small)
                .background(MaterialTheme.colorScheme.inverseOnSurface)
                .padding(15.dp)
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.weight(2f))
                Text(
                    text = "Submit review",
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = onDismiss) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Sort by name"
                    )
                }
            }
            OutlinedTextField(
                value = text,
                onValueChange = { input -> text = input},
                placeholder = { Text(text = "Your comment") },
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
            if (rating > 0 && text.isNotBlank()) {
                ClippedIconButton(
                    text = "Submit",
                    onClick = { onConfirmation(text, rating) }
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
            listOf(),
            { _, _ ->},
            showButton = false
        )
    }
}
package com.master.app.ui.repairment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.master.app.ui.model.Review
import com.master.app.ui.component.RatingsStar
import com.master.app.ui.theme.AndroidAppTheme

@Composable
fun RepairmanReviews(
    reviews: List<Review>,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.small)
            .background(MaterialTheme.colorScheme.inverseOnSurface)
            .padding(10.dp)
    ) {
        Text(
            text = "Reviews from customers",
            style = MaterialTheme.typography.titleLarge
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier.heightIn(0.dp, 500.dp)
        ) {
            items(reviews) {
                ReviewCard(review = it)
            }
        }
        if (reviews.isEmpty()) {
            Text(
                text = "No reviews yet.",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Composable
fun ReviewCard(
    review: Review,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.small)
            .background(MaterialTheme.colorScheme.onPrimary)
            .padding(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.fillMaxWidth()
        ) {
            Column {
                Text(
                    text = review.author,
                    style = MaterialTheme.typography.titleSmall
                )
                Text(
                    text = review.date,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
            RatingsStar(
                rating = review.rating.toDouble()
            )
        }
        Spacer(modifier = Modifier.height(7.dp))
        Text(
            text = review.comment,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground,
            maxLines = 4,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RepairmanReviewsPreview() {
    AndroidAppTheme {
        RepairmanReviews(
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
            )
        )
    }
}
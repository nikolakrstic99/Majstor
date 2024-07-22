package com.master.app.ui.repairment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.master.app.data.model.Review
import com.master.app.ui.component.ClippedIconButton
import com.master.app.ui.theme.AndroidAppTheme

@Composable
fun RepairmanReviewsScreenContent(
    reviews: List<Review>,
    onReviewRepairmanClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        RepairmanRatings(
            ratings = reviews.map { it.rating }
        )
        ReviewRepairmanButton()
        RepairmanReviews(
            reviews = reviews
        )
    }
}

@Composable
fun ReviewRepairmanButton(
    modifier: Modifier = Modifier
) {
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
            onClick = { /*TODO*/ },
            Modifier.width(150.dp)
        )
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
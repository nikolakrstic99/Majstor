package com.master.app.ui.repairment

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.master.app.R
import com.master.app.data.model.Review
import com.master.app.ui.theme.AndroidAppTheme
import kotlin.math.ceil

@SuppressLint("DefaultLocale")
@Composable
fun RepairmanReviews(
    reviews: List<Review>,
    modifier: Modifier = Modifier
) {
    val ratings = reviews.map { it.rating }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.small)
            .background(MaterialTheme.colorScheme.inverseOnSurface)
            .padding(10.dp)
    ) {
        Text(
            text = "Ratings:",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            RatingsSlider(
                ratings = ratings,
                Modifier.height(120.dp)
            )
            Spacer(modifier = Modifier.width(25.dp))
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.height(120.dp)
            ) {
                Text(
                    text = String.format("%.2f", ratings.average()),
                    style = MaterialTheme.typography.displaySmall
                )
                RatingsStar(
                    averageRating = ratings.average()
                )
                Text(
                    text = "${ratings.size} reviews",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}

@Composable
fun RatingsSlider(
    ratings: List<Int>,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxHeight()
    ) {
        for (rating in 5 downTo 1) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = rating.toString(),
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.secondary
                )
                Spacer(
                    modifier = Modifier.width(10.dp)
                )
                LinearProgressIndicator(
                    progress = ratings.filter { it == rating }.size.toFloat() / ratings.size,
                    Modifier
                        .width(200.dp)
                        .clip(MaterialTheme.shapes.medium)
                )
            }
        }
    }
}

@Composable
fun RatingsStar(
    averageRating: Double,
    modifier: Modifier = Modifier
) {
    val maxRating = 5
    val starSize = 15.dp

    Row {
        // Full stars
        repeat(averageRating.toInt()) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Full Star",
                tint = Color.Black,
                modifier = Modifier.size(starSize)
            )
        }
        // Half star
        if (averageRating > averageRating.toInt()) {
            Image(
                painter = painterResource(id = R.drawable.star_half),
                contentDescription = "Half star",
                modifier = Modifier.size(starSize)
            )
        }
        // Empty stars
        repeat(5 - ceil(averageRating).toInt()) {
            Image(
                painter = painterResource(id = R.drawable.empty_star),
                contentDescription = "Empty star",
                modifier = Modifier.size(starSize)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RepairmanCommentsPreview() {
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
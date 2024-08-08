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
import androidx.compose.material.icons.filled.Star
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
import com.master.app.ui.model.Review
import com.master.app.ui.component.RatingsStar
import com.master.app.ui.theme.AndroidAppTheme
import kotlin.math.ceil

@SuppressLint("DefaultLocale")
@Composable
fun RepairmanRatings(
    ratings: List<Int>,
    modifier: Modifier = Modifier
) {
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
                    rating = ratings.average()
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

@Preview(showBackground = true)
@Composable
fun RepairmanCommentsPreview() {
    AndroidAppTheme {
        RepairmanRatings(
            listOf(2, 2, 3, 4)
        )
    }
}
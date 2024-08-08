package com.master.app.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.master.app.R
import com.master.app.ui.repairment.RepairmanRatings
import com.master.app.ui.theme.AndroidAppTheme
import kotlin.math.ceil

@Composable
fun RatingsStar(
    rating: Double,
    modifier: Modifier = Modifier
) {
    val maxRating = 5
    val starSize = 15.dp

    Row {
        // Full stars
        repeat(rating.toInt()) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Full Star",
                tint = Color.Black,
                modifier = Modifier.size(starSize)
            )
        }
        // Half star
        if (rating > rating.toInt()) {
            Image(
                painter = painterResource(id = R.drawable.star_half),
                contentDescription = "Half star",
                modifier = Modifier.size(starSize)
            )
        }
        // Empty stars
        repeat(maxRating - ceil(rating).toInt()) {
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
fun RatingStarsPreview() {
    AndroidAppTheme {
        RatingsStar(rating = 3.5)
    }
}
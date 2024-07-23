package com.master.app.ui.repairment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.master.app.ui.theme.AndroidAppTheme

@Composable
fun RepairmanContactScreen(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        InfoCard(
            title = "Contact number",
            icon = Icons.Filled.Call,
            text = "0621482242"
        )
        InfoCard(
            title = "Location",
            icon = Icons.Filled.LocationOn,
            text = "Vladimira Popovica 46"
        )
        InfoCard(
            title = "Business hours",
            icon = Icons.Filled.DateRange,
            text = "Monday: 09:00 - 17:00\n" +
                    "Tuesday: 09:00 - 17:00\n" +
                    "Wednesday: 09:00 - 17:00\n" +
                    "Thursday: 09:00 - 17:00\n" +
                    "Friday: 09:00 - 17:00\n" +
                    "Saturday: 09:00 - 17:00\n" +
                    "Sunday: 09:00 - 17:00"
        )
    }
}

@Composable
fun InfoCard(
    title: String,
    icon: ImageVector,
    text: String,
    modifier: Modifier = Modifier
) {
    val iconSize = 30.dp
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.small)
            .background(MaterialTheme.colorScheme.inverseOnSurface)
            .padding(20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "Icon",
                modifier = Modifier.size(iconSize)
            )
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Spacer(modifier = Modifier.width(iconSize))
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RepairmanContactScreenPreview() {
    AndroidAppTheme {
        RepairmanContactScreen()
    }
}
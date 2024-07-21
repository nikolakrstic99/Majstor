package com.master.app.ui.repairment

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.master.app.ui.theme.AndroidAppTheme

@SuppressLint("DefaultLocale")
@Composable
fun RepairmanServices(
    averageRating: Double,
    providedServices: List<String>,
    modifier: Modifier = Modifier
) {
    val allServices = listOf(
        "Postavljanje parketa", "Postavljanje laminata", "Hoblovanje parketa",
        "Postavljanje lajsni", "Lakiranje parketa", "Brodski pod", "Skidanje parketa")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.small)
            .background(MaterialTheme.colorScheme.inverseOnSurface)
            .padding(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = "Services provided",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Rating: " + String.format("%.2f", averageRating),
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.secondary
            )
        }
        Divider()
        LazyColumn {
           items(allServices) { service ->
               Spacer(modifier = Modifier.height(8.dp))
               ServiceCard(
                   service = service,
                   isProvided = service in providedServices
               )
           }
        }
    }
}

@Composable
fun ServiceCard(
    service: String,
    isProvided: Boolean,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.small)
            .background(MaterialTheme.colorScheme.onPrimary)
            .padding(5.dp)
    ) {
        Icon(
            imageVector = if (isProvided) Icons.Filled.Check else Icons.Filled.Clear,
            contentDescription = "Service provided icon"
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = service,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RepairmanServicesPreview() {
    AndroidAppTheme {
        RepairmanServices(
            averageRating = 8.8,
            providedServices = listOf("Postavljanje laminata", "Skidanje parketa", "Postavljanje parketa")
        )
    }
}
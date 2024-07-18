package com.master.app.ui.repairment

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.master.app.data.model.Repairman
import com.master.app.ui.theme.AndroidAppTheme

@SuppressLint("DefaultLocale")
@Composable
fun RepairmanPreview(
    repairman: Repairman,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.extraSmall)
            .background(MaterialTheme.colorScheme.secondary)
            .padding(10.dp)
    ) {
        Text(
            text = repairman.name,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSecondary
        )
        Text(
            text = String.format("%.2f", repairman.averageRating),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSecondary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RepairmanPreviewPreview() {
    AndroidAppTheme {
        RepairmanPreview(
            Repairman(
                1,
                "Milojko Pantic",
                8.3723725,
                listOf("Moler", "Parketar")
            )
        )
    }
}
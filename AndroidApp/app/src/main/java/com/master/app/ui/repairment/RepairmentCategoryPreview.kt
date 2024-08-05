package com.master.app.ui.repairment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.master.app.R
import com.master.app.data.model.RepairmentCategory
import com.master.app.ui.theme.AndroidAppTheme

@Composable
fun RepairmentCategoryPreview(
    repairmentCategory: RepairmentCategory,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(10.dp)
    ) {
        //        AsyncImage(
//            model = exampleImage,
//            contentDescription = "Blog preview picture",
//            modifier = Modifier
//                .padding(10.dp)
//                .size(100.dp)
//                .clip(MaterialTheme.shapes.medium)
//        )
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Preview image",
            modifier = Modifier
                .padding(10.dp)
                .size(50.dp)
                .clip(MaterialTheme.shapes.small)
        )
        Text(
            text = repairmentCategory.name,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = "${repairmentCategory.repairmenCount} majstora",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RepairmentPreview() {
    AndroidAppTheme {
        RepairmentCategoryPreview(
            RepairmentCategory(
                1,
                "Gradjevinski radovi",
                136,
                "pictureURL"
            )
        )
    }
}
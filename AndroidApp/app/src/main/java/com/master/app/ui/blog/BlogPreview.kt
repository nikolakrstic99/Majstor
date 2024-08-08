package com.master.app.ui.blog

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.master.app.R
import com.master.app.ui.model.BlogInfo
import com.master.app.ui.theme.AndroidAppTheme

const val exampleImage = "https://cdn.freecodecamp.org/curriculum/cat-photo-app/relaxing-cat.jpg"

@Composable
fun BlogPreview(
    blog: BlogInfo,
    modifier: Modifier = Modifier
) {
    Row (
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier.fillMaxSize()
    ){
        Box(
            modifier = Modifier.fillMaxHeight(),
            contentAlignment = Alignment.Center
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
                    .padding(5.dp)
                    .size(100.dp)
                    .clip(MaterialTheme.shapes.medium)
            )
        }
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = blog.title,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "${blog.author}, ${blog.publishTime}",
                color = MaterialTheme.colorScheme.tertiary,
                style = MaterialTheme.typography.labelSmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = blog.description,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BlogInfoPreview() {
    AndroidAppTheme {
        BlogPreview(
            BlogInfo(
                1,
                "A Breakdown of the Full English Breakfast",
                "Welcome to Weekend Brunch! Skip the lines and make brunch at home. The coffee’s truly bottomless and the best part is PJs all the way! This week: a guide to the gloriousness that is known as A Full English Breakfast.home. The coffee’s truly bottomless and the best part is PJs all the way! This week: a guide to the gloriousness that is known as A Full English Breakfast.",
                "picture",
                "01.04.2024",
                "Andrej Jokic"
            )
        )
    }
}
package com.master.app.ui.component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import com.master.app.utils.decodeBase64ToBitmap

@Composable
fun Base64Image(
    base64Str: String,
    modifier: Modifier = Modifier
) {
    val imageBitMap = decodeBase64ToBitmap(base64Str)?.asImageBitmap()
    if (imageBitMap != null) {
        Image(
            bitmap = imageBitMap,
            contentDescription = "Image",
            modifier = modifier,
            contentScale = ContentScale.Crop
        )
    }
}


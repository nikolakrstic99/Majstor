package com.master.app.ui.component
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.master.app.utils.decodeBase64ToBitmap

@Composable
fun Base64Image(
    base64Str: String,
    modifier: Modifier = Modifier,
    clickable: Boolean = true
) {
    var shouldEnlarge by remember { mutableStateOf(false) }
    val clickableModifier =
        if (clickable)
            modifier.clickable { shouldEnlarge = !shouldEnlarge }
        else
            modifier

    val imageBitMap = decodeBase64ToBitmap(base64Str)?.asImageBitmap()
    if (imageBitMap != null) {
        Image(
            bitmap = imageBitMap,
            contentDescription = "Image",
            contentScale = ContentScale.Crop,
            modifier = clickableModifier
        )
        if (shouldEnlarge) {
            Dialog(
                onDismissRequest = { shouldEnlarge = false },
                properties = DialogProperties(usePlatformDefaultWidth = false),
            ) {
                Image(
                    bitmap = imageBitMap,
                    contentDescription = "Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(30.dp)
                )
            }
        }
    }
}


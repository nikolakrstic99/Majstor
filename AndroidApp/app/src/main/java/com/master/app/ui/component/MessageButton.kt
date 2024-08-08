package com.master.app.ui.component

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.master.app.ui.theme.AndroidAppTheme

@Composable
fun MessageButton(
    phoneNumber: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        IconButton(
            onClick = {
                // Open message app with the number
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("smsto:$phoneNumber")
                }
                context.startActivity(intent)
            },
            modifier = modifier
                .size(35.dp)
                .clip(CircleShape)
        ) {
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = "Open phone app"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MessageButtonPreview() {
    AndroidAppTheme {
        MessageButton(
            phoneNumber = "0621482242"
        )
    }
}
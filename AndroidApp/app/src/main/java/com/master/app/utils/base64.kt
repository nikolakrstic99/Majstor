package com.master.app.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Base64
import java.io.ByteArrayOutputStream
import java.io.InputStream

fun decodeBase64ToBitmap(base64Str: String): Bitmap? {
    return try {
        val pureBased64Encoded = base64Str.substring(base64Str.indexOf(",") + 1)
        val decodedBytes = Base64.decode(pureBased64Encoded, Base64.DEFAULT)
        BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
    } catch (e: IllegalArgumentException) {
        e.printStackTrace()
        null
    }
}

fun uriToBase64(context: Context, uri: Uri): String? {
    return try {
        val bytes = context.contentResolver.openInputStream(uri)?.readBytes()
        val ret = Base64
            .encodeToString(bytes, Base64.DEFAULT)
            .replace("\n", "") // Get rid of newlines
        "data:image/png;base64,$ret"
    } catch (error: Exception) {
        error.printStackTrace() // This exception always occurs
        null
    }
}

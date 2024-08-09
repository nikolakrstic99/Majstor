package com.master.app.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64

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
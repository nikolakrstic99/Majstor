package com.master.app.data.source

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val requestBuilder = chain.request().newBuilder()

        // If token has been saved, add it to the request
        if (LocalStorageManager.contains("token")) {
            val token = LocalStorageManager.getString("token", "")
            requestBuilder.addHeader("Authorization", "Bearer $token")
        }

        return chain.proceed(requestBuilder.build())
    }
}
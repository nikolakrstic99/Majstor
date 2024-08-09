package com.master.app.data.source

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    // localhost (127.0.0.1) refers to the device or emulator itself
    // 10.0.2.2 is a special alias to your host loopback interface
    private const val BASE_URL = "http://10.0.2.2:8080/api/v1/"

    val api by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okhttpClient())
            .build()
            .create(ApiService::class.java)
    }

    /**
     * Initialize OkhttpClient with interceptor
     */
    private fun okhttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor())
            .build()
    }
}
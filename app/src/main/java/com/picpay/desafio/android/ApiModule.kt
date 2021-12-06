package com.picpay.desafio.android

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {
    fun retrofit() = Retrofit.Builder()
        .baseUrl(url)
        .client(buildOkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun buildOkHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        okHttpClientBuilder.addInterceptor(interceptor)

        return okHttpClientBuilder.build()
    }

    private val url = "https://609a908e0f5a13001721b74e.mockapi.io/picpay/api/"

    val service: PicPayService = retrofit().create(PicPayService::class.java)
}
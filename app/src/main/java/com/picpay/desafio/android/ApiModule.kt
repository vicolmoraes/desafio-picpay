package com.picpay.desafio.android

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {
    fun retrofit() = Retrofit.Builder()
        .baseUrl(url)
        .client(okHttp)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    private val okHttp: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .build()
    }

    private val gson: Gson by lazy { GsonBuilder().create() }

    private val url = "https://609a908e0f5a13001721b74e.mockapi.io/picpay/api/"


    val service: PicPayService by lazy {
        retrofit().create(PicPayService::class.java)
    }
}
package com.example.retrofit.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private const val ENDPOINT = "https://pixabay.com"

    fun getRetrofit() =
        Retrofit.Builder()
            .baseUrl(ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getApiClient() =
        getRetrofit().create(ApiClient::class.java)
}
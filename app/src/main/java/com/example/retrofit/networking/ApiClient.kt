package com.example.retrofit.networking

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("api")
    fun getAllImages(@Query("key") key: String = "3588873-8bb0e70fdfcef7f31eee25461"): Call<PixabayResponse>

    @GET("api")
    fun getImagesByQuery(@Query("q") q: String, @Query("key") key: String = "3588873-8bb0e70fdfcef7f31eee25461"): Call<PixabayResponse>

}
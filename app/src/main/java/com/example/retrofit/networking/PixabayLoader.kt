package com.example.retrofit.networking

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PixabayLoader (
    private val onSuccess: (PixabayResponse) -> Unit,
    private val onError: (Throwable) -> Unit
){
    fun loadImages() {
        ApiFactory.getApiClient()
            .getAllImages()
            .enqueue(object : Callback<PixabayResponse> {
                override fun onResponse(
                    call: Call<PixabayResponse>,
                    response: Response<PixabayResponse>
                ) {
                    onSuccess(response.body()!!)
                }

                override fun onFailure(call: Call<PixabayResponse>, t: Throwable) {
                    onError(t)
                }

            })
    }

    fun loadImagesByQuery(q: String) {
        ApiFactory.getApiClient()
            .getImagesByQuery(q)
            .enqueue(object : Callback<PixabayResponse> {
                override fun onResponse(
                    call: Call<PixabayResponse>,
                    response: Response<PixabayResponse>
                ) {
                    onSuccess(response.body()!!)
                }

                override fun onFailure(call: Call<PixabayResponse>, t: Throwable) {
                    onError(t)
                }

            })
    }
}
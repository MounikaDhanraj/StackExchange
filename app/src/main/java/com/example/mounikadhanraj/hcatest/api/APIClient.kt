package com.example.mounikadhanraj.hcatest.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIClient {

    private const val BASE_URL = "https://api.stackexchange.com/2.2/"

    private fun buildRetrofit() : Retrofit
    {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService : APIService = buildRetrofit().create(
        APIService::class.java
    )
}
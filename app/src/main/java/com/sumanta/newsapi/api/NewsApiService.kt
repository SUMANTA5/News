package com.sumanta.newsapi.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsApiService {

    fun create() : NewsApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(NewsApi::class.java)
        return service

    }
}
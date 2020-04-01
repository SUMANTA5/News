package com.sumanta.newsapi.api

import com.sumanta.newsapi.data.NewsArticles
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface NewsApi {

    @GET("top-headlines?country=in&apiKey=9dd000ae757d47ce81d11591348b5a3f")
    fun getTopHighlights(): Call<NewsArticles>

    @GET("top-headlines?country=in&category=sports&apiKey=9dd000ae757d47ce81d11591348b5a3f")
    fun getSportsNews() : Call<NewsArticles>

    @GET("top-headlines?country=in&category=business&apiKey=9dd000ae757d47ce81d11591348b5a3f")
    fun getBusinessNews() : Call<NewsArticles>
}
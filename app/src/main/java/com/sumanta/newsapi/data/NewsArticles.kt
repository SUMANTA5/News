package com.sumanta.newsapi.data

data class NewsArticles(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
package com.example.heroretrofit.model.data

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
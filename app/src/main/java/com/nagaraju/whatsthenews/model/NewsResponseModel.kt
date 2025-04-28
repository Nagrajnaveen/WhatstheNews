package com.nagaraju.whatsthenews.model

data class NewsResponseModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
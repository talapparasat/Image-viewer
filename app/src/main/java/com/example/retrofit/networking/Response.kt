package com.example.retrofit.networking

data class Hit(
    val tags: String,
    val likes: Int,
    val webformatURL: String,
    val largeImageURL: String
)

data class PixabayResponse(
    val total: Int,
    val totalHits: Int,
    val hits: List<Hit>
)
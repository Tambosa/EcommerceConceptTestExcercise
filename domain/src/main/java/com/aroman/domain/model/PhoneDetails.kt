package com.aroman.domain.model

data class PhoneDetails(
    val cpu: String,
    val camera: String,
    val capacity: List<Int>,
    val color: List<String>,
    val id: Int,
    val imageUrls: List<String>,
    val isFavourites: Boolean = false,
    val price: Int,
    val rating: Float,
    val sd: String,
    val ssd: String,
    val title: String,
)

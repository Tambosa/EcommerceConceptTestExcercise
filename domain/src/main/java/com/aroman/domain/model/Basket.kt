package com.aroman.domain.model

data class Basket(
    val basketItemList: List<BasketItem>,
    val delivery: String,
    val id: Int,
    val totalPrice: Int
)

data class BasketItem(
    val id: Int,
    val imageUrl: String,
    val price: Int,
    val title: String,
    var count: Int = 1,
)
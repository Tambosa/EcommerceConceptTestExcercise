package com.aroman.domain.model

data class Cart(
    val cartItemList: List<CartItem>,
    val delivery: String,
    val id: Int,
    val totalPrice: Int
)

data class CartItem(
    val id: Int,
    val imageUrl: String,
    val price: Int,
    val title: String,
    var count: Int = 1,
)
package com.aroman.domain.model

data class HomePage(
    val homeStore: List<HomeStoreItem>,
    val bestSeller: List<BestSellerItem>,
)

data class HomeStoreItem(
    val id: Int,
    val isNew: Boolean = false,
    val title: String,
    val subtitle: String,
    val pictureUrl: String,
    val isBuy: Boolean
)

data class BestSellerItem(
    val id: Int,
    val is_favorites: Boolean = false,
    val title: String,
    val price_without_discount: Int,
    val discount_price: String,
    val isBuy: Boolean
)
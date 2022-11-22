package com.aroman.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cart(
    val cartItemList: List<CartItem>,
    val delivery: String,
    val id: Int,
    val totalPrice: Int
) : Parcelable

@Parcelize
data class CartItem(
    val id: Int,
    val imageUrl: String,
    val price: Int,
    val title: String,
    var count: Int = 1,
) : Parcelable
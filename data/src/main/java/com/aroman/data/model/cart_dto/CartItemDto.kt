package com.aroman.data.model.cart_dto

import com.aroman.domain.model.CartItem
import com.google.gson.annotations.SerializedName

data class CartItemDto(
    @SerializedName("id") val id: Int,
    @SerializedName("images") val imageUrl: String,
    @SerializedName("price") val price: Int,
    @SerializedName("title") val title: String
)

fun CartItemDto.toCartItem() = CartItem(
    id = id,
    imageUrl = imageUrl,
    price = price,
    title = title
)
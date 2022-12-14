package com.aroman.data.model.cart_dto

import com.aroman.domain.model.Cart
import com.google.gson.annotations.SerializedName

data class CartDto(
    @SerializedName("basket") val cart: List<CartItemDto>,
    @SerializedName("delivery") val delivery: String,
    @SerializedName("id") val id: Int,
    @SerializedName("total") val total: Int
)

fun CartDto.toBasket() = Cart(
    cartItemList = cart.map { it.toCartItem() },
    delivery = delivery,
    id = id,
    totalPrice = total,
)
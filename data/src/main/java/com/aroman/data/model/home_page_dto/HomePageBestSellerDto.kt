package com.aroman.data.model.home_page_dto

import com.aroman.domain.model.BestSellerItem
import com.google.gson.annotations.SerializedName

data class HomePageBestSellerDto(
    @SerializedName("discount_price") val discountPrice: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("is_favorites") val isFavorites: Boolean,
    @SerializedName("picture") val picture: String,
    @SerializedName("price_without_discount") val priceWithoutDiscount: Int,
    @SerializedName("title") val title: String
)

fun HomePageBestSellerDto.toBestSellerItem() = BestSellerItem(
    discountPrice = discountPrice,
    id = id,
    isFavorites = isFavorites,
    pictureUrl = picture,
    priceWithoutDiscount = priceWithoutDiscount,
    title = title
)
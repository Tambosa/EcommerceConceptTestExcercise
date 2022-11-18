package com.aroman.data.model.home_page_dto

import com.aroman.domain.model.HomeStoreItem
import com.google.gson.annotations.SerializedName

data class HomePageHomeStoreDto(
    @SerializedName("id") val id: Int,
    @SerializedName("is_buy") val isBuy: Boolean,
    @SerializedName("is_new") val isNew: Boolean,
    @SerializedName("picture") val picture: String,
    @SerializedName("subtitle") val subtitle: String,
    @SerializedName("title") val title: String
)

fun HomePageHomeStoreDto.toHomeStoreItem() = HomeStoreItem(
    id = id,
    isBuy = isBuy,
    isNew = isNew,
    pictureUrl = picture,
    subtitle = subtitle,
    title = title
)
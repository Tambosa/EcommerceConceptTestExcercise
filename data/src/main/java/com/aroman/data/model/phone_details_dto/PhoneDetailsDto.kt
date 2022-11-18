package com.aroman.data.model.phone_details_dto

import com.aroman.domain.model.PhoneDetails
import com.google.gson.annotations.SerializedName

data class PhoneDetailsDto(
    @SerializedName("CPU") val cpu: String,
    @SerializedName("camera") val camera: String,
    @SerializedName("capacity") val capacity: List<Int>,
    @SerializedName("color") val color: List<String>,
    @SerializedName("id") val id: Int,
    @SerializedName("images") val images: List<String>,
    @SerializedName("isFavorites") val isFavorites: Boolean,
    @SerializedName("price") val price: Int,
    @SerializedName("rating") val rating: Float,
    @SerializedName("sd") val sd: String,
    @SerializedName("ssd") val ssd: String,
    @SerializedName("title") val title: String
)

fun PhoneDetailsDto.toPhoneDetails() = PhoneDetails(
    cpu = cpu,
    camera = camera,
    capacity = capacity,
    color = color,
    id = id,
    imageUrls = images,
    isFavourites = isFavorites,
    price = price,
    rating = rating,
    sd = sd,
    ssd = ssd,
    title = title,
)
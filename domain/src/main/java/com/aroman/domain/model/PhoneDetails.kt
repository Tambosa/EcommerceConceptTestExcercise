package com.aroman.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PhoneDetails(
    val cpu: String,
    val camera: String,
    val capacity: List<Int>,
    val color: List<String>,
    val id: Int,
    val imageUrls: List<String>,
    var isFavourites: Boolean = false,
    val price: Int,
    val rating: Float,
    val sd: String,
    val ssd: String,
    val title: String,
) : Parcelable

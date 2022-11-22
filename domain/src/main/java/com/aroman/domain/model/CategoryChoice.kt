package com.aroman.domain.model

data class CategoryChoice(
    val iconResId: Int,
    val name: String,
    var isChecked: Boolean = false
)

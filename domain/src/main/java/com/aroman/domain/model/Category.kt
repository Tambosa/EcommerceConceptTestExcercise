package com.aroman.domain.model

data class Category(
    val iconId: Int,
    val name: String,
    var isChecked: Boolean = false
)

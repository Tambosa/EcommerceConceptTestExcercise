package com.aroman.ecommerceconcepttestexcercise.ui.home

import com.aroman.domain.model.CategoryChoice
import com.aroman.ecommerceconcepttestexcercise.R

object ProductCategories {
    fun get() = listOf<CategoryChoice>(
        CategoryChoice(R.drawable.ic_phone, "Phones", false),
        CategoryChoice(R.drawable.ic_computer, "Computer", false),
        CategoryChoice(R.drawable.ic_health, "Health", false),
        CategoryChoice(R.drawable.ic_book, "Books", false),
    )
}
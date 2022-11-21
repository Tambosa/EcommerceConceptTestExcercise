package com.aroman.ecommerceconcepttestexcercise.ui.home

import com.aroman.domain.model.Category
import com.aroman.ecommerceconcepttestexcercise.R

object ProductCategories {
    fun get() = listOf<Category>(
        Category(R.drawable.ic_phone, "Phones", false),
        Category(R.drawable.ic_computer, "Computer", false),
        Category(R.drawable.ic_health, "Health", false),
        Category(R.drawable.ic_book, "Books", false),
    )
}
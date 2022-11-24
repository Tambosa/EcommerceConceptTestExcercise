package com.aroman.app.test_utils

import com.aroman.domain.model.Cart
import com.aroman.domain.model.HomePage
import com.aroman.domain.model.PhoneDetails

object EntityProvider {
    fun getHomePage() = HomePage(
        bestSeller = listOf(),
        homeStore = listOf(),
    )

    fun getPhoneDetails() = PhoneDetails(
        cpu = "",
        camera = "",
        capacity = listOf(),
        color = listOf(),
        id = 1,
        imageUrls = listOf(),
        isFavourites = true,
        price = 1,
        rating = 1f,
        sd = "",
        ssd = "",
        title = "",
    )

    fun getCart() = Cart(
        cartItemList = listOf(),
        delivery = "",
        id = 1,
        totalPrice = 1,
    )
}
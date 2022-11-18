package com.aroman.domain.repository

import com.aroman.domain.model.Basket
import com.aroman.domain.model.HomePage
import com.aroman.domain.model.PhoneDetails

interface MockyRepository {
    suspend fun getCartContents(): Basket
    suspend fun getHomePage(): HomePage
    suspend fun getPhoneDetails(phoneId: Int): PhoneDetails
}
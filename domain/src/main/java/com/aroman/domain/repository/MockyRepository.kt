package com.aroman.domain.repository

import com.aroman.domain.model.Cart
import com.aroman.domain.model.HomePage
import com.aroman.domain.model.PhoneDetails

interface MockyRepository {
    suspend fun getCartContents(): Cart
    suspend fun getHomePage(): HomePage
    suspend fun getPhoneDetails(phoneId: Int): PhoneDetails
}
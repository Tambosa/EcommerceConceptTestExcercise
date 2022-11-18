package com.aroman.domain.repository

import com.aroman.domain.model.Basket

interface CartRepository {
    suspend fun getCartContents(): Basket
}
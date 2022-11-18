package com.aroman.domain.repository

import com.aroman.domain.model.HomePage

interface HomePageRepository {
    suspend fun getHomePage(): HomePage
}
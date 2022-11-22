package com.aroman.data.repository

import com.aroman.data.model.cart_dto.toBasket
import com.aroman.data.model.home_page_dto.toHomePage
import com.aroman.data.model.phone_details_dto.toPhoneDetails
import com.aroman.data.repository.retrofit.MockyApi
import com.aroman.domain.repository.MockyRepository

class MockyRepositoryImpl(private val api: MockyApi) : MockyRepository {

    override suspend fun getCartContents() = api.getCart().toBasket()

    override suspend fun getHomePage() = api.getHomePage().toHomePage()

    override suspend fun getPhoneDetails(phoneId: Int) = api.getPhoneDetails().toPhoneDetails()
}
package com.aroman.data.repository.retrofit

import com.aroman.data.model.cart_dto.CartDto
import com.aroman.data.model.home_page_dto.HomePageDto
import com.aroman.data.model.phone_details_dto.PhoneDetailsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MockyApi {
    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getHomePage(): HomePageDto

    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    suspend fun getPhoneDetails(): PhoneDetailsDto

    @GET("53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    suspend fun getCart(): CartDto
}
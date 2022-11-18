package com.aroman.domain.repository

import com.aroman.domain.model.PhoneDetails

interface PhoneDetailsRepository {
    suspend fun getPhoneDetails(phoneId: Int):  PhoneDetails
}
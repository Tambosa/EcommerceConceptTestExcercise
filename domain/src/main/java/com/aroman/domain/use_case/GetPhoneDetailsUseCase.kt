package com.aroman.domain.use_case

import com.aroman.domain.model.PhoneDetails
import com.aroman.domain.model.Resource
import com.aroman.domain.repository.MockyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPhoneDetailsUseCase(private val repo: MockyRepository) {
    operator fun invoke(phoneId: Int): Flow<Resource<PhoneDetails>> = flow {
        try {
            emit(Resource.Loading())
            val phoneDetails = repo.getPhoneDetails(phoneId)
            emit(Resource.Success(phoneDetails))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Unknown Error"))
        }
    }
}
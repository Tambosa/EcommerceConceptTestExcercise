package com.aroman.domain.use_case

import com.aroman.domain.model.Cart
import com.aroman.domain.model.Resource
import com.aroman.domain.repository.MockyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCartUseCase (private val repo: MockyRepository) {
    operator fun invoke(): Flow<Resource<Cart>> = flow {
        try {
            emit(Resource.Loading())
            val cart = repo.getCartContents()
            emit(Resource.Success(cart))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Unknown Error"))
        }
    }
}
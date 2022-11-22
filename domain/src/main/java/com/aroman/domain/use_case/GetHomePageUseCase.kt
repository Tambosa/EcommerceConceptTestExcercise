package com.aroman.domain.use_case

import com.aroman.domain.model.HomePage
import com.aroman.domain.model.Resource
import com.aroman.domain.repository.MockyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetHomePageUseCase(private val repo: MockyRepository) {
    operator fun invoke(): Flow<Resource<HomePage>> = flow {
        try {
            emit(Resource.Loading())
            val homePage = repo.getHomePage()
            emit(Resource.Success(homePage))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Unknown Error"))
        }
    }
}
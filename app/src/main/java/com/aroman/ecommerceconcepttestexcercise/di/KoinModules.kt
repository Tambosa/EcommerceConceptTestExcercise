package com.aroman.ecommerceconcepttestexcercise.di

import com.aroman.data.repository.MockyRepositoryImpl
import com.aroman.data.repository.retrofit.MockyApi
import com.aroman.data.repository.retrofit.RetrofitClient
import com.aroman.domain.repository.MockyRepository
import org.koin.dsl.module

object KoinModules {

    val repository = module {
        single<MockyApi> {
            RetrofitClient().provideRetrofit().create(MockyApi::class.java)
        }
        single<MockyRepository> { MockyRepositoryImpl(get<MockyApi>()) }
    }

    val viewModel = module {
//        viewModel { MainActivityViewModel(get<RedditRepository>(), get<LocalRedditRepository>()) }
    }
}
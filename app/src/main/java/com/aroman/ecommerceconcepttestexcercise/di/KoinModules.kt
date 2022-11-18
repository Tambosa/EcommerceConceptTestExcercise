package com.aroman.ecommerceconcepttestexcercise.di

import com.aroman.data.repository.MockyRepositoryImpl
import com.aroman.data.repository.retrofit.MockyApi
import com.aroman.data.repository.retrofit.RetrofitClient
import com.aroman.domain.repository.MockyRepository
import com.aroman.domain.use_case.GetCartUseCase
import com.aroman.domain.use_case.GetHomePageUseCase
import com.aroman.domain.use_case.GetPhoneDetailsUseCase
import com.aroman.ecommerceconcepttestexcercise.ui.cart.CartViewModel
import com.aroman.ecommerceconcepttestexcercise.ui.details.DetailsViewModel
import com.aroman.ecommerceconcepttestexcercise.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object KoinModules {

    val repository = module {
        single<MockyApi> {
            RetrofitClient().provideRetrofit().create(MockyApi::class.java)
        }
        single<MockyRepository> { MockyRepositoryImpl(get<MockyApi>()) }
        single<GetCartUseCase> { GetCartUseCase(get<MockyRepository>()) }
        single<GetPhoneDetailsUseCase> { GetPhoneDetailsUseCase((get<MockyRepository>())) }
        single<GetHomePageUseCase> { GetHomePageUseCase((get<MockyRepository>())) }
    }

    val viewModel = module {
        viewModel<HomeViewModel> { HomeViewModel(get<GetHomePageUseCase>()) }
        viewModel<CartViewModel> { CartViewModel(get<GetCartUseCase>()) }
        viewModel<DetailsViewModel> { DetailsViewModel(get<GetPhoneDetailsUseCase>()) }
    }
}
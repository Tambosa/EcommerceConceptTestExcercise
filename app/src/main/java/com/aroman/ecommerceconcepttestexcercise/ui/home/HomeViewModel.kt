package com.aroman.ecommerceconcepttestexcercise.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aroman.domain.model.HomePage
import com.aroman.domain.model.Resource
import com.aroman.domain.use_case.GetHomePageUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class HomeViewModel(private val getHomePageUseCase: GetHomePageUseCase) : ViewModel() {
    private val _homePageData = MutableLiveData<HomePage>()
    val homePageData: LiveData<HomePage> = _homePageData

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getHomePage() {
        getHomePageUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _isLoading.postValue(false)
                    _homePageData.postValue(result.data)
                }
                is Resource.Error -> {
                    _isLoading.postValue(false)
                    result.message?.let { Log.d("@@@", it) }
                }
                is Resource.Loading -> {
                    _isLoading.postValue(true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
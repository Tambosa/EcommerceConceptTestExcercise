package com.aroman.ecommerceconcepttestexcercise.ui.cart

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aroman.domain.model.Cart
import com.aroman.domain.model.Resource
import com.aroman.domain.use_case.GetCartUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class CartViewModel(private val getCartUseCase: GetCartUseCase) : ViewModel() {
    private val _cartData = MutableLiveData<Cart>()
    val cartData: LiveData<Cart> = _cartData

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getCart() {
        getCartUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _isLoading.postValue(false)
                    _cartData.postValue(result.data)
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
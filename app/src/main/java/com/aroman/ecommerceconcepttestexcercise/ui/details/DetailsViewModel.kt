package com.aroman.ecommerceconcepttestexcercise.ui.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aroman.domain.model.PhoneDetails
import com.aroman.domain.model.Resource
import com.aroman.domain.use_case.GetPhoneDetailsUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class DetailsViewModel(private val getPhoneDetailsUseCase: GetPhoneDetailsUseCase) : ViewModel() {
    private val _homeDetailsData = MutableLiveData<PhoneDetails>()
    val homeDetailsData: LiveData<PhoneDetails> = _homeDetailsData

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getPhoneDetails(phoneId: Int) {
        getPhoneDetailsUseCase(phoneId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _isLoading.postValue(false)
                    _homeDetailsData.postValue(result.data)
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
package com.aroman.ecommerceconcepttestexcercise

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.aroman.data.repository.MockyRepositoryImpl
import com.aroman.data.repository.retrofit.MockyApi
import com.aroman.data.repository.retrofit.RetrofitClient
import com.aroman.domain.repository.MockyRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val repo: MockyRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_EcommerceConceptTestExcercise)
    }

    override fun onStart() {
        super.onStart()
        lifecycleScope.launch{
            Log.d("@@@", "\ngetHomePage\n" + repo.getHomePage().toString())
            Log.d("@@@", "\ngetCartContents\n" + repo.getCartContents().toString())
            Log.d("@@@", "\ngetPhoneDetails\n" + repo.getPhoneDetails(1).toString())
        }
    }
}
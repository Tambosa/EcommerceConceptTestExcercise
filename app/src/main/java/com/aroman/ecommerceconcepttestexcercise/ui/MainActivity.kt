package com.aroman.ecommerceconcepttestexcercise.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aroman.ecommerceconcepttestexcercise.R
import com.aroman.ecommerceconcepttestexcercise.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_EcommerceConceptTestExcercise)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, HomeFragment())
            .commit()
    }
}
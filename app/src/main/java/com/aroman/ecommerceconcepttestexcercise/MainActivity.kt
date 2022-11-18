package com.aroman.ecommerceconcepttestexcercise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_EcommerceConceptTestExcercise)
    }

    override fun onStart() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, HomeFragment())
            .commit()
    }
}
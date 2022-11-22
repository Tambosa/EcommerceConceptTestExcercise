package com.aroman.ecommerceconcepttestexcercise.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aroman.ecommerceconcepttestexcercise.R
import com.aroman.ecommerceconcepttestexcercise.databinding.ActivityMainBinding
import com.aroman.ecommerceconcepttestexcercise.ui.cart.CartFragment
import com.aroman.ecommerceconcepttestexcercise.ui.cart.CartViewModel
import com.aroman.ecommerceconcepttestexcercise.ui.home.HomeFragment
import com.aroman.ecommerceconcepttestexcercise.utils.showShortToast
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: CartViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding
    lateinit var tapBar: ChipNavigationBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_EcommerceConceptTestExcercise)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        supportFragmentManager.beginTransaction()
            .replace(binding.mainContainer.id, HomeFragment())
            .commit()

        tapBar = binding.tapBar
        initBottomMenu()
        initViewModel()
    }

    private fun initBottomMenu() {
        binding.tapBar.setItemSelected(R.id.menu_explorer, true)

        binding.tapBar.setOnItemSelectedListener { menuId ->
            when (menuId) {
                R.id.menu_cart -> supportFragmentManager.beginTransaction()
                    .replace(binding.mainContainer.id, CartFragment())
                    .addToBackStack(null)
                    .commit()
                R.id.menu_explorer -> supportFragmentManager.popBackStack()
                R.id.menu_profile -> this.showShortToast("Profile not implemented")
                R.id.menu_favourites -> this.showShortToast("Favourites not implemented")
            }
        }
    }

    private fun initViewModel() {
        viewModel.cartData.observe(this) { data ->
            binding.tapBar.showBadge(R.id.menu_cart, data.cartItemList.size)
        }
        viewModel.getCart()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        tapBar.setItemSelected(R.id.menu_explorer, true)
    }
}
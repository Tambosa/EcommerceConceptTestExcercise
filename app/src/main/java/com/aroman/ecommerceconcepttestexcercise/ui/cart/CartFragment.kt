package com.aroman.ecommerceconcepttestexcercise.ui.cart

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.aroman.ecommerceconcepttestexcercise.databinding.FragmentCartBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CartFragment : Fragment() {
    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CartViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        loadData()
    }

    private fun initViewModel() {
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            //nothing
        }
        viewModel.cartData.observe(viewLifecycleOwner) { data ->
            Log.d("@@@", data.toString())
        }
    }

    private fun loadData() {
        viewModel.getCart()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
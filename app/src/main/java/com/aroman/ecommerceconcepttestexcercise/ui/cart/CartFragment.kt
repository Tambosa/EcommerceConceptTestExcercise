package com.aroman.ecommerceconcepttestexcercise.ui.cart

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.aroman.ecommerceconcepttestexcercise.R
import com.aroman.ecommerceconcepttestexcercise.databinding.FragmentCartBinding
import com.aroman.ecommerceconcepttestexcercise.ui.MainActivity
import com.aroman.ecommerceconcepttestexcercise.ui.cart.adapters.CartAdapter
import com.aroman.ecommerceconcepttestexcercise.utils.showShortToast
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.DecimalFormat

class CartFragment : Fragment() {
    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CartViewModel by viewModel()
    private val cartAdapter = CartAdapter(
        { position -> onPlusClick(position) },
        { position -> onMinusClick(position) },
        { position -> onDeleteClick(position) })

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
        binding.buttonBack.setOnClickListener {
            parentFragmentManager.popBackStack()
            (activity as MainActivity).tapBar.setItemSelected(R.id.menu_explorer, true)
        }
    }

    private fun initViewModel() {
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            //nothing
        }
        viewModel.cartData.observe(viewLifecycleOwner) { data ->
            Log.d("@@@", data.toString())
            binding.cartRecyclerView.adapter = cartAdapter
            binding.cartRecyclerView.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            cartAdapter.setData(data.cartItemList)

            binding.price.text = DecimalFormat("$#,###").format(data.totalPrice)
            binding.deliveryPrice.text = data.delivery
            binding.buttonCheckout.setOnClickListener {
                requireContext().showShortToast("Checkout clicked")
            }
        }
    }

    private fun loadData() {
        viewModel.getCart()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun onDeleteClick(position: Int) {
        requireContext().showShortToast("${cartAdapter.getData()[position].title} delete clicked")
    }

    private fun onMinusClick(position: Int) {
        var totalPrice = 0
        for (item in cartAdapter.getData()) {
            totalPrice += item.price * item.count
        }
        binding.price.text = DecimalFormat("$#,###").format(totalPrice)
    }

    private fun onPlusClick(position: Int) {
        var totalPrice = 0
        for (item in cartAdapter.getData()) {
            totalPrice += item.price * item.count
        }
        binding.price.text = DecimalFormat("$#,###").format(totalPrice)
    }
}
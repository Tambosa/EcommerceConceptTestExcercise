package com.aroman.ecommerceconcepttestexcercise.ui.cart

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.aroman.domain.model.Cart
import com.aroman.ecommerceconcepttestexcercise.R
import com.aroman.ecommerceconcepttestexcercise.databinding.FragmentCartBinding
import com.aroman.ecommerceconcepttestexcercise.ui.MainActivity
import com.aroman.ecommerceconcepttestexcercise.ui.cart.adapters.MainCartAdapter
import com.aroman.ecommerceconcepttestexcercise.utils.showShortToast
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.DecimalFormat

class CartFragment : Fragment() {
    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CartViewModel by viewModel()

    // Adapter Delegate
    private val cartAdapter = MainCartAdapter(
        { position -> onPlusClicked(position) },
        { position -> onMinusClicked(position) },
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
            initView(data)
        }
    }

    private fun initView(cartData: Cart) {
        binding.cartRecyclerView.adapter = cartAdapter
        binding.cartRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        cartAdapter.items = cartData.cartItemList

        var totalPrice = 0
        for (item in cartData.cartItemList) {
            totalPrice += item.price * item.count
        }
        binding.price.text = DecimalFormat("$#,###").format(totalPrice)

        binding.deliveryPrice.text = cartData.delivery
        binding.buttonCheckout.setOnClickListener {
            requireContext().showShortToast("Checkout clicked")
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
        requireContext().showShortToast("Delete clicked")
    }

    private fun onPlusClicked(position: Int) {
        viewModel.increaseItemQuantity(position)
        cartAdapter.notifyItemChanged(position)
    }

    private fun onMinusClicked(position: Int) {
        viewModel.reduceItemQuantity(position)
        cartAdapter.notifyItemChanged(position)
    }
}
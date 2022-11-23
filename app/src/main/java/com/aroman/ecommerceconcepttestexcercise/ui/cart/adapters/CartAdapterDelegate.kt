package com.aroman.ecommerceconcepttestexcercise.ui.cart.adapters

import coil.load
import com.aroman.domain.model.CartItem
import com.aroman.domain.model.DisplayableItem
import com.aroman.ecommerceconcepttestexcercise.databinding.ItemCartBinding
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import java.text.DecimalFormat

fun cartAdapterDelegate(
    onPlusClicked: (position: Int) -> Unit,
    onMinusClicked: (position: Int) -> Unit,
    onDeleteClicked: (position: Int) -> Unit,
) = adapterDelegateViewBinding<CartItem, DisplayableItem, ItemCartBinding>({ layoutInflater, root ->
    ItemCartBinding.inflate(layoutInflater, root, false)
}) {
    binding.buttonMinus.setOnClickListener {
        onMinusClicked(layoutPosition)
    }

    binding.buttonPlus.setOnClickListener {
        onPlusClicked(layoutPosition)
    }
    binding.buttonDelete.setOnClickListener {
        onDeleteClicked(layoutPosition)
    }
    bind {
        binding.image.load(item.imageUrl)
        binding.title.text = item.title
        binding.price.text = DecimalFormat("$#,###,###.00").format(item.price)
        binding.quantity.text = item.count.toString()
    }
}
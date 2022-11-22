package com.aroman.ecommerceconcepttestexcercise.ui.cart.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.aroman.domain.model.CartItem
import com.aroman.ecommerceconcepttestexcercise.databinding.ItemCartBinding
import java.text.DecimalFormat

class CartAdapter(
    private val onPlusClick: (position: Int) -> Unit,
    private val onMinusClick: (position: Int) -> Unit,
    private val onDeleteClick: (position: Int) -> Unit,
) :
    RecyclerView.Adapter<CartAdapter.CartItemViewHolder>() {
    private var data = listOf<CartItem>()

    fun setData(data: List<CartItem>) {
        this.data = data
    }

    fun getData() = data

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CartItemViewHolder(
        ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        onPlusClick,
        onMinusClick,
        onDeleteClick
    )

    override fun onBindViewHolder(
        holder: CartItemViewHolder,
        position: Int
    ) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    inner class CartItemViewHolder(
        private val binding: ItemCartBinding,
        private val onPlusClick: (position: Int) -> Unit,
        private val onMinusClick: (position: Int) -> Unit,
        private val onDeleteClick: (position: Int) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cartItem: CartItem) {
            binding.image.load(cartItem.imageUrl)
            binding.title.text = cartItem.title
            binding.price.text = DecimalFormat("$#,###,###.00").format(cartItem.price)
            binding.quantity.text = cartItem.count.toString()
            binding.buttonMinus.setOnClickListener {
                if (cartItem.count > 1) cartItem.count -= 1
                onMinusClick(layoutPosition)
                notifyItemChanged(layoutPosition)
            }

            binding.buttonPlus.setOnClickListener {
                cartItem.count += 1
                onPlusClick(layoutPosition)
                notifyItemChanged(layoutPosition)
            }
            binding.buttonDelete.setOnClickListener {
                onDeleteClick(layoutPosition)
            }
        }
    }
}
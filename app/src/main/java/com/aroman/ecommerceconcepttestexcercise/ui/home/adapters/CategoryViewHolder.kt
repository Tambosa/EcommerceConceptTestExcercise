package com.aroman.ecommerceconcepttestexcercise.ui.home.adapters

import androidx.recyclerview.widget.RecyclerView
import com.aroman.domain.model.Category
import com.aroman.ecommerceconcepttestexcercise.R
import com.aroman.ecommerceconcepttestexcercise.databinding.ItemCategoryBinding

class CategoryViewHolder(
    private val binding: ItemCategoryBinding,
    private val onItemClick: (position: Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Category) {
        binding.categoryButton.setImageDrawable(itemView.context.getDrawable(item.iconId))
        binding.categoryText.text = item.name
        binding.categoryButton.setOnClickListener {
            onItemClick(layoutPosition)
            resetColor()
            if (item.isChecked) changeColor()
        }
    }

    fun changeColor() {
        binding.categoryButton.imageTintList =
            itemView.context.resources.getColorStateList(R.color.white, null)
        binding.categoryButton.background.setTint(itemView.context.getColor(R.color.ecommerce_orange))
        binding.categoryText.setTextColor(itemView.context.getColor(R.color.ecommerce_orange))
    }

    fun resetColor() {
        binding.categoryButton.imageTintList =
            itemView.context.resources.getColorStateList(R.color.ecommerce_grey_dark, null)
        binding.categoryButton.background.setTint(itemView.context.getColor(R.color.white))
        binding.categoryText.setTextColor(itemView.context.getColor(R.color.ecommerce_deep_blue))
    }
}
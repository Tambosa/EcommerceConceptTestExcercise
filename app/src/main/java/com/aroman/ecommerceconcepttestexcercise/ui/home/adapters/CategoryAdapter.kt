package com.aroman.ecommerceconcepttestexcercise.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aroman.domain.model.CategoryChoice
import com.aroman.ecommerceconcepttestexcercise.R
import com.aroman.ecommerceconcepttestexcercise.databinding.ItemCategoryBinding

class CategoryAdapter(private val onItemClick: (position: Int) -> Unit) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private var data = listOf<CategoryChoice>()
    private var lastCheckedPosition: Int = 0

    fun setData(data: List<CategoryChoice>) {
        this.data = data
    }

    fun getData() = data

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CategoryViewHolder(
        ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        onItemClick
    )

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    inner class CategoryViewHolder(
        private val binding: ItemCategoryBinding,
        private val onItemClick: (position: Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CategoryChoice) {
            binding.categoryButton.setImageDrawable(itemView.context.getDrawable(item.iconResId))
            binding.categoryText.text = item.name
            if (item.isChecked) {
                changeColor()
            } else {
                resetColor()
            }
            binding.categoryButton.setOnClickListener {
                data[lastCheckedPosition].isChecked = false
                notifyItemChanged(lastCheckedPosition)
                data[layoutPosition].isChecked = true
                notifyItemChanged(layoutPosition)

                lastCheckedPosition = layoutPosition
                onItemClick(layoutPosition)
            }
        }

        private fun changeColor() {
            binding.categoryButton.imageTintList =
                itemView.context.resources.getColorStateList(R.color.white, null)
            binding.categoryButton.background.setTint(itemView.context.getColor(R.color.ecommerce_orange))
            binding.categoryText.setTextColor(itemView.context.getColor(R.color.ecommerce_orange))
        }

        private fun resetColor() {
            binding.categoryButton.imageTintList =
                itemView.context.resources.getColorStateList(R.color.ecommerce_grey_dark, null)
            binding.categoryButton.background.setTint(itemView.context.getColor(R.color.white))
            binding.categoryText.setTextColor(itemView.context.getColor(R.color.ecommerce_deep_blue))
        }
    }
}
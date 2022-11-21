package com.aroman.ecommerceconcepttestexcercise.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aroman.domain.model.Category
import com.aroman.ecommerceconcepttestexcercise.databinding.ItemCategoryBinding

class CategoryAdapter(private val onItemClick: (position: Int) -> Unit) :
    RecyclerView.Adapter<CategoryViewHolder>() {

    private var data = listOf<Category>()

    fun setData(data: List<Category>) {
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
}
package com.aroman.ecommerceconcepttestexcercise.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aroman.domain.model.BestSellerItem
import com.aroman.ecommerceconcepttestexcercise.databinding.ItemBestSellerBinding

class BestSellerAdapter(
    private val onItemClick: (position: Int) -> Unit,
    private val onFavouriteClick: (position: Int) -> Unit
) :
    RecyclerView.Adapter<BestSellerViewHolder>() {

    private var data = listOf<BestSellerItem>()

    fun setData(data: List<BestSellerItem>) {
        this.data = data
        notifyDataSetChanged()
    }

    fun getData() = data

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BestSellerViewHolder(
        ItemBestSellerBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        onFavouriteClick
    )

    override fun onBindViewHolder(holder: BestSellerViewHolder, position: Int) {
        holder.bind(data[position])
        holder.itemView.setOnClickListener { onItemClick(position) }
    }

    override fun getItemCount() = data.size
}

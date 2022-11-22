package com.aroman.ecommerceconcepttestexcercise.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.aroman.domain.model.BestSellerItem
import com.aroman.ecommerceconcepttestexcercise.R
import com.aroman.ecommerceconcepttestexcercise.databinding.ItemBestSellerBinding
import java.text.DecimalFormat

class BestSellerAdapter(
    private val onItemClick: (position: Int) -> Unit,
    private val onFavouriteClick: (position: Int) -> Unit
) :
    RecyclerView.Adapter<BestSellerAdapter.BestSellerViewHolder>() {

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

    inner class BestSellerViewHolder(
        private val binding: ItemBestSellerBinding,
        private val onFavouriteClick: (position: Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: BestSellerItem) {
            binding.imageBestSeller.load(item.pictureUrl)
            binding.priceBestSeller.text =
                "$${DecimalFormat("#,###").format(item.priceWithoutDiscount)}"
            binding.oldPriceBestSeller.text =
                "$${DecimalFormat("#,###").format(item.discountPrice)}"
            binding.titleBestSeller.text = item.title
            binding.buttonFavourite.setImageDrawable(
                if (item.isFavorites) itemView.context.getDrawable(R.drawable.ic_favourite_true_background)
                else itemView.context.getDrawable(R.drawable.ic_favourite_false_foreground)
            )
            binding.buttonFavourite.setOnClickListener {
                onFavouriteClick(layoutPosition)
            }
        }
    }
}

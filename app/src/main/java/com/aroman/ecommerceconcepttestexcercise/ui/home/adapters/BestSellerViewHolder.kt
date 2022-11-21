package com.aroman.ecommerceconcepttestexcercise.ui.home.adapters

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.aroman.domain.model.BestSellerItem
import com.aroman.ecommerceconcepttestexcercise.R
import com.aroman.ecommerceconcepttestexcercise.databinding.ItemBestSellerBinding
import java.text.DecimalFormat

class BestSellerViewHolder(
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
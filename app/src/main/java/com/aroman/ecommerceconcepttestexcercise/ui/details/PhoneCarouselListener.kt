package com.aroman.ecommerceconcepttestexcercise.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.aroman.ecommerceconcepttestexcercise.databinding.DetailsCarouselBinding
import org.imaginativeworld.whynotimagecarousel.listener.CarouselListener
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import org.imaginativeworld.whynotimagecarousel.utils.setImage

object PhoneCarouselListener : CarouselListener {

    override fun onBindViewHolder(
        binding: ViewBinding,
        item: CarouselItem,
        position: Int
    ) {
        val currentBinding = binding as DetailsCarouselBinding
        currentBinding.image.apply {
            setImage(item)
        }
    }

    override fun onCreateViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup
    ): ViewBinding {
        return DetailsCarouselBinding.inflate(layoutInflater, parent, false)
    }
}
package com.aroman.data.model.home_page_dto

import com.aroman.domain.model.HomePage
import com.google.gson.annotations.SerializedName

data class HomePageDto(
    @SerializedName("best_seller") val bestSeller: List<HomePageBestSellerDto>,
    @SerializedName("home_store") val homeStore: List<HomePageHomeStoreDto>
)

fun HomePageDto.toHomePage() = HomePage(
    homeStore.map { it.toHomeStoreItem() },
    bestSeller.map { it.toBestSellerItem() })

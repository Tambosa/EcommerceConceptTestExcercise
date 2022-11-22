package com.aroman.ecommerceconcepttestexcercise.ui.details.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.aroman.domain.model.PhoneDetails
import com.aroman.ecommerceconcepttestexcercise.ui.details.ChildDetailsFragment
import com.aroman.ecommerceconcepttestexcercise.ui.details.ChildFeaturesFragment
import com.aroman.ecommerceconcepttestexcercise.ui.details.ChildShopFragment
import com.aroman.ecommerceconcepttestexcercise.ui.details.DetailsFragment

class BottomSheetAdapter(
    fragment: DetailsFragment,
    private val data: PhoneDetails
) : FragmentStateAdapter(fragment) {

    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ChildShopFragment.newInstance(data)
            1 -> ChildDetailsFragment.newInstance(data)
            else -> ChildFeaturesFragment.newInstance(data)
        }
    }
}
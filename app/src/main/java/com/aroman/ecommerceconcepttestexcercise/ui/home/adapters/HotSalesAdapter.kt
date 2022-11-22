package com.aroman.ecommerceconcepttestexcercise.ui.home.adapters

import android.os.Handler
import android.os.Looper
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.aroman.domain.model.HomeStoreItem
import com.aroman.ecommerceconcepttestexcercise.ui.home.ChildHotSalesFragment
import com.aroman.ecommerceconcepttestexcercise.ui.home.HomeFragment

class HotSalesAdapter(
    fragment: HomeFragment,
    private val itemList: List<HomeStoreItem>
) : FragmentStateAdapter(fragment) {

    override fun getItemCount() = itemList.size

    override fun createFragment(position: Int) =
        ChildHotSalesFragment.newInstance(itemList[position])
}

fun ViewPager2.autoScroll(interval: Long) {
    var scrollPosition = 0
    val handler = Handler(Looper.getMainLooper())
    val runnable = object : Runnable {
        override fun run() {
            val count = this@autoScroll.adapter?.itemCount ?: 0
            setCurrentItem(scrollPosition++ % count, true)

            handler.postDelayed(this, interval)
        }
    }

    this.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            scrollPosition = position + 1
        }
    })
    handler.post(runnable)
}
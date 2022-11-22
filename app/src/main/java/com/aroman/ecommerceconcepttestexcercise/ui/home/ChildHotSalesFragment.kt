package com.aroman.ecommerceconcepttestexcercise.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.aroman.domain.model.HomeStoreItem
import com.aroman.ecommerceconcepttestexcercise.databinding.ChildFragmentHotSalesBinding

class ChildHotSalesFragment : Fragment() {
    private var _binding: ChildFragmentHotSalesBinding? = null
    private val binding get() = _binding!!

    private lateinit var hotSales: HomeStoreItem

    companion object {
        fun newInstance(hotSales: HomeStoreItem) = ChildHotSalesFragment().apply {
            this.hotSales = hotSales
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ChildFragmentHotSalesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        renderView()
    }

    private fun renderView() {
        binding.apply {
            hotSalesTitle.text = hotSales.title
            hotSalesSubtitle.text = hotSales.subtitle
            imageHotSales.load(hotSales.pictureUrl)
            hotSalesNew.visibility = if (hotSales.isNew) View.VISIBLE else View.GONE
            hotSalesBuyButton.visibility = if (hotSales.isBuy) View.VISIBLE else View.GONE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
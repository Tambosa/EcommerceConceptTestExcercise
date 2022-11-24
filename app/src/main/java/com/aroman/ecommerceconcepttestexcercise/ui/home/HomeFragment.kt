package com.aroman.ecommerceconcepttestexcercise.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.aroman.domain.model.HomeStoreItem
import com.aroman.ecommerceconcepttestexcercise.R
import com.aroman.ecommerceconcepttestexcercise.databinding.BottomSheetHomeBinding
import com.aroman.ecommerceconcepttestexcercise.databinding.FragmentHomeBinding
import com.aroman.ecommerceconcepttestexcercise.ui.details.DetailsFragment
import com.aroman.ecommerceconcepttestexcercise.ui.home.adapters.BestSellerAdapter
import com.aroman.ecommerceconcepttestexcercise.ui.home.adapters.CategoryAdapter
import com.aroman.ecommerceconcepttestexcercise.ui.home.adapters.HotSalesAdapter
import com.aroman.ecommerceconcepttestexcercise.ui.home.adapters.autoScroll
import com.aroman.ecommerceconcepttestexcercise.utils.showShortToast
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModel()

    private val categoryAdapter = CategoryAdapter { position -> onCategoryItemClick(position) }
    private val bestSellerAdapter =
        BestSellerAdapter({ position -> onBestSellerItemClick(position) },
            { position -> onBestSellerFavouriteClick(position) })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        initCategoryRecycler()
        initBestSellerRecycler()
        initButtons()
        loadData()
    }

    private fun initButtons() {
        binding.categoryViewAll.setOnClickListener {
            showFilterOptions()
        }
        binding.hotSalesSeeMore.setOnClickListener {
            showFilterOptions()
        }
        binding.bestSellerSeeMore.setOnClickListener {
            showFilterOptions()
        }
    }

    private fun initBestSellerRecycler() {
        binding.recyclerBestSeller.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerBestSeller.adapter = bestSellerAdapter
    }

    private fun initCategoryRecycler() {
        binding.recyclerCategory.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerCategory.adapter = categoryAdapter
        categoryAdapter.setData(ProductCategories.get())
    }

    private fun initViewModel() {
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }
        viewModel.homePageData.observe(viewLifecycleOwner) { homePageData ->
            Log.d("@@@", homePageData.toString())
            bestSellerAdapter.setData(homePageData.bestSeller)

            initViewPager(homePageData.homeStore)
        }
    }

    private fun initViewPager(hotSalesList: List<HomeStoreItem>) {
        binding.hotSalesViewPager.apply {
            val hotSalesAdapter = HotSalesAdapter(this@HomeFragment, hotSalesList)
            adapter = hotSalesAdapter
            this.autoScroll(3000)
        }
    }

    private fun loadData() {
        viewModel.getHomePage()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun onCategoryItemClick(position: Int) {
        requireContext().showShortToast(categoryAdapter.getData()[position].toString())
    }

    private fun onBestSellerItemClick(position: Int) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.main_container, DetailsFragment())
            .addToBackStack(null)
            .commit()
    }

    private fun onBestSellerFavouriteClick(position: Int) {
        requireContext().showShortToast(bestSellerAdapter.getData()[position].title + " like clicked")
    }

    private fun showFilterOptions() {
        val dialogBinding = BottomSheetHomeBinding.inflate(LayoutInflater.from(requireContext()))
        val dialog = BottomSheetDialog(requireContext()).apply {
            setContentView(dialogBinding.root)
        }

        initDialogOnClicks(dialog, dialogBinding)
        initSpinners(dialogBinding)
        dialog.show()
    }

    private fun initDialogOnClicks(
        dialog: BottomSheetDialog,
        dialogBinding: BottomSheetHomeBinding
    ) {
        dialogBinding.buttonClose.setOnClickListener { dialog.hide() }
        dialogBinding.buttonDone.setOnClickListener {
            requireContext().showShortToast("${dialogBinding.spinnerBrand.selectedItem} ${dialogBinding.spinnerPrice.selectedItem} ${dialogBinding.spinnerSize.selectedItem}")
            dialog.hide()
        }
    }

    private fun initSpinners(dialogBinding: BottomSheetHomeBinding) {
        initSpinnerFromStringArray(R.array.bottom_sheet_spinner_brand, dialogBinding.spinnerBrand)
        initSpinnerFromStringArray(R.array.bottom_sheet_spinner_price, dialogBinding.spinnerPrice)
        initSpinnerFromStringArray(R.array.bottom_sheet_spinner_size, dialogBinding.spinnerSize)
    }

    private fun initSpinnerFromStringArray(stringArray: Int, spinner: Spinner) {
        ArrayAdapter.createFromResource(
            requireContext(),
            stringArray,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }
}
package com.aroman.ecommerceconcepttestexcercise.ui.details

import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.aroman.domain.model.CapacityChoice
import com.aroman.domain.model.ColorChoice
import com.aroman.domain.model.PhoneDetails
import com.aroman.ecommerceconcepttestexcercise.R
import com.aroman.ecommerceconcepttestexcercise.databinding.BottomSheetDetailsBinding
import com.aroman.ecommerceconcepttestexcercise.databinding.FragmentDetailsBinding
import com.aroman.ecommerceconcepttestexcercise.ui.details.adapters.BottomSheetAdapter
import com.aroman.ecommerceconcepttestexcercise.ui.details.adapters.CapacityChoiceAdapter
import com.aroman.ecommerceconcepttestexcercise.ui.details.adapters.ColorChoiceAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.tabs.TabLayoutMediator
import org.imaginativeworld.whynotimagecarousel.model.CarouselGravity
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import org.imaginativeworld.whynotimagecarousel.model.CarouselType
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.DecimalFormat

class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var dialogBinding: BottomSheetDetailsBinding
    private val viewModel: DetailsViewModel by viewModel()

    private val colorChoiceAdapter = ColorChoiceAdapter { position -> onColorItemClick(position) }
    private val capacityChoiceAdapter =
        CapacityChoiceAdapter { position -> onCapacityItemClick(position) }

    private lateinit var phoneDetails: PhoneDetails

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initOnClicks()
        initViewModel()
        loadData()
    }

    private fun initOnClicks() {
        binding.buttonBack.setOnClickListener { parentFragmentManager.popBackStack() }
        binding.buttonCart.setOnClickListener {
            //goToCart
        }
    }

    private fun initViewModel() {
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }
        viewModel.homeDetailsData.observe(viewLifecycleOwner) { data ->
            phoneDetails = data
            Log.d("@@@", phoneDetails.toString())
            initCarousel(phoneDetails.imageUrls)
            binding.buttonShowDetails.setOnClickListener {
                openDialog()
            }
        }
    }

    private fun openDialog() {
        dialogBinding = BottomSheetDetailsBinding.inflate(LayoutInflater.from(requireContext()))
        val dialog = BottomSheetDialog(requireContext()).apply {
            setContentView(dialogBinding.root)
        }
        dialogBinding.apply {
            title.text = phoneDetails.title
            ratingBar.rating = phoneDetails.rating
            price.text = DecimalFormat("$#,###,###.00").format(phoneDetails.price)
            recolorFavourites(buttonFavourite)
        }

        dialogBinding.viewPager.adapter = BottomSheetAdapter(this@DetailsFragment, phoneDetails)
        TabLayoutMediator(dialogBinding.tabLayout, dialogBinding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Shop"
                1 -> "Details"
                2 -> "Features"
                else -> ""
            }
        }.attach()

        initDialogOnClicks(dialog, dialogBinding)
        initChoiceRecyclers(dialogBinding)
        dialog.show()
    }

    private fun initDialogOnClicks(
        dialog: BottomSheetDialog,
        dialogBinding: BottomSheetDetailsBinding
    ) {
        dialogBinding.buttonFavourite.setOnClickListener {
            phoneDetails.isFavourites = !phoneDetails.isFavourites
            recolorFavourites(dialogBinding.buttonFavourite)
        }
        dialogBinding.buttonAddToCart.setOnClickListener {
            var result = ""
            for (colorChoice in colorChoiceAdapter.getData()) {
                if (colorChoice.isChosen) result += "color: ${colorChoice.color}"
            }

            for (capacityChoice in capacityChoiceAdapter.getData()) {
                if (capacityChoice.isChosen) result += " capacity: ${capacityChoice.capacity}"
            }
            Toast.makeText(requireContext(), result, Toast.LENGTH_SHORT).show()
        }
    }

    private fun recolorFavourites(buttonFavourite: ImageButton) {
        buttonFavourite.setImageDrawable(
            if (phoneDetails.isFavourites) requireContext().getDrawable(R.drawable.ic_favourite_true_background)
            else requireContext().getDrawable(R.drawable.ic_favourite_false_foreground)
        )
    }

    private fun initChoiceRecyclers(dialogBinding: BottomSheetDetailsBinding) {
        dialogBinding.recyclerColor.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = colorChoiceAdapter
            colorChoiceAdapter.setData(phoneDetails.color.map { ColorChoice(it) })
        }
        dialogBinding.recyclerCapacity.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = capacityChoiceAdapter
            capacityChoiceAdapter.setData(phoneDetails.capacity.map { CapacityChoice(it) })
        }
    }

    private fun onColorItemClick(position: Int) {
        Toast.makeText(
            requireContext(),
            colorChoiceAdapter.getData()[position].toString(),
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun onCapacityItemClick(position: Int) {
        Toast.makeText(
            requireContext(),
            capacityChoiceAdapter.getData()[position].toString(),
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun initCarousel(imageUrls: List<String>) {
        binding.carousel.carouselListener = PhoneCarouselListener
        binding.carousel.apply {
            registerLifecycle(viewLifecycleOwner)
            showTopShadow = false
            showBottomShadow = false
            carouselType = CarouselType.SHOWCASE
            scaleOnScroll = true
            scalingFactor = 0.2f
            infiniteCarousel = true
            carouselGravity = CarouselGravity.START
            autoPlay = false
            setData(imageUrls.map { CarouselItem(it) })
            next()
        }
    }

    private fun loadData() {
        viewModel.getPhoneDetails(HARDCODED_PHONE_ID)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private const val HARDCODED_PHONE_ID = 1
    }
}
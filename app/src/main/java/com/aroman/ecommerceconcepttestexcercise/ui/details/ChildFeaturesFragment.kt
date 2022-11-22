package com.aroman.ecommerceconcepttestexcercise.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.aroman.domain.model.PhoneDetails
import com.aroman.ecommerceconcepttestexcercise.databinding.ChildFragmentFeaturesBinding

class ChildFeaturesFragment : Fragment() {
    private var _binding: ChildFragmentFeaturesBinding? = null
    private val binding get() = _binding!!

    private lateinit var phoneDetails: PhoneDetails

    companion object {
        private const val PHONE_DETAILS = "phoneDetails"
        fun newInstance(phoneDetails: PhoneDetails) = ChildFeaturesFragment().apply {
            arguments = bundleOf(PHONE_DETAILS to phoneDetails)
            this.phoneDetails = phoneDetails
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ChildFragmentFeaturesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        renderView()
    }

    private fun renderView() {
        binding.apply {
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
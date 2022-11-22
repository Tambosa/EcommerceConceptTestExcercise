package com.aroman.ecommerceconcepttestexcercise.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.aroman.domain.model.PhoneDetails
import com.aroman.ecommerceconcepttestexcercise.databinding.ChildFragmentDetailsBinding

class ChildDetailsFragment : Fragment() {
    private var _binding: ChildFragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private lateinit var phoneDetails: PhoneDetails

    companion object {
        fun newInstance(phoneDetails: PhoneDetails) = ChildDetailsFragment().apply {
            this.phoneDetails = phoneDetails
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ChildFragmentDetailsBinding.inflate(inflater, container, false)
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
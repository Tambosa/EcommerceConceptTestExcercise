package com.aroman.ecommerceconcepttestexcercise.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.aroman.domain.model.PhoneDetails
import com.aroman.ecommerceconcepttestexcercise.databinding.ChildFragmentShopBinding

class ChildShopFragment : Fragment() {
    private var _binding: ChildFragmentShopBinding? = null
    private val binding get() = _binding!!

    private lateinit var phoneDetails: PhoneDetails

    companion object {
        fun newInstance(phoneDetails: PhoneDetails) = ChildShopFragment().apply {
            this.phoneDetails = phoneDetails
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ChildFragmentShopBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        renderView()
    }

    private fun renderView() {
        binding.apply {
            textCpu.text = phoneDetails.cpu
            textCamera.text = phoneDetails.camera
            textSsd.text = phoneDetails.ssd
            textSd.text = phoneDetails.sd
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
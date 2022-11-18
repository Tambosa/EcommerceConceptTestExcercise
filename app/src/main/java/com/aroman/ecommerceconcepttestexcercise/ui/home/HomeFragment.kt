package com.aroman.ecommerceconcepttestexcercise.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.aroman.ecommerceconcepttestexcercise.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModel()

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
        loadData()
    }

    private fun initViewModel() {
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            //nothing
        }
        viewModel.homePageData.observe(viewLifecycleOwner) { homePageData ->
            Log.d("@@@", homePageData.toString())
        }
    }

    private fun loadData() {
        viewModel.getHomePage()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
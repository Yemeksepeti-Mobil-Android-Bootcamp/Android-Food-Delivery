package com.example.foodDelivery.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.foodDelivery.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: Fragment() {
    private var _binding:FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        initViews()
        return binding.root
    }

    private fun initViews() {
        val adapter = HomeViewPagerAdapter(requireActivity())
        binding.apply {
            viewPagerHome.adapter = adapter
//            viewPagerHome.setPageTransformer(DepthPageTransformer())
            bottomBar.setupWithViewPager2(viewPagerHome)
            bottomBar.selectTabAt(1)
        }
    }
}
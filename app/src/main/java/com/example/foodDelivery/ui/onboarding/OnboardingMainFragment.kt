package com.example.foodDelivery.ui.onboarding

import DepthPageTransformer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.foodDelivery.databinding.FragmentOnboardingMainBinding

class OnboardingMainFragment:Fragment(){
    private lateinit var binding: FragmentOnboardingMainBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnboardingMainBinding.inflate(layoutInflater,container,false)
        val view = binding.root
        initViewPager()
        return view
    }

    private fun initViewPager() {
        val adapter = OnboardingViewPagerAdapter(requireActivity())
        binding.viewPager.adapter = adapter
        //animation
        binding.viewPager.setPageTransformer(DepthPageTransformer())
        //Indicator
        binding.dotsIndicator.setViewPager2(binding.viewPager)
    }
}
package com.example.foodDelivery.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.foodDelivery.databinding.FragmentOnboardingMainBinding
import com.example.foodDelivery.utils.anim.DepthPageTransformer

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
        binding.apply {
            viewPager.adapter = adapter
            viewPager.setPageTransformer(DepthPageTransformer())
            dotsIndicator.setViewPager2(binding.viewPager)
        }
    }
}
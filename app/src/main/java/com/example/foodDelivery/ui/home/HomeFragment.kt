package com.example.foodDelivery.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.foodDelivery.databinding.FragmentHomeBinding
import com.example.foodDelivery.ui.onboarding.OnboardingViewPagerAdapter
import com.example.foodDelivery.ui.splash.SplashViewModel
import com.example.foodDelivery.utils.anim.DepthPageTransformer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: Fragment() {
    private var _binding:FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()
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
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.observeNavigationLiveData().observe(viewLifecycleOwner,{
        })
        viewModel.getUser()
    }
}
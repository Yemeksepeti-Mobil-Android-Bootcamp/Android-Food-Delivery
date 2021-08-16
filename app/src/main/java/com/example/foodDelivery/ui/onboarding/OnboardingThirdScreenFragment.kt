package com.example.foodDelivery.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.foodDelivery.databinding.FragmentOnboardingThirdScreenBinding

class OnboardingThirdScreenFragment:Fragment() {

    private lateinit var binding: FragmentOnboardingThirdScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingThirdScreenBinding.inflate(layoutInflater,container,false)
        val view = binding.root
        initViews()
        return view
    }

    private fun initViews() {
        binding.homeButton.setOnClickListener(){
           // findNavController().navigate(R.id.action_onboardingFragment_to_homeFragment)
        }
    }
}
package com.example.foodDelivery.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.foodDelivery.ui.onboarding.OnboardingFirstScreenFragment
import com.example.foodDelivery.ui.onboarding.OnboardingSecondScreenFragment
import com.example.foodDelivery.ui.onboarding.OnboardingThirdScreenFragment


private const val FRAGMENT_COUNT = 3

class HomeViewPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int =FRAGMENT_COUNT

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> OnboardingFirstScreenFragment()
            1 -> OnboardingSecondScreenFragment()
            2 -> OnboardingThirdScreenFragment()
            else -> OnboardingThirdScreenFragment()
        }
    }
}
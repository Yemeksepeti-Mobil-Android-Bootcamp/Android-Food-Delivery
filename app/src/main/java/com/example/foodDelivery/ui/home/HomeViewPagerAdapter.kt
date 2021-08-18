package com.example.foodDelivery.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.foodDelivery.ui.onboarding.OnboardingThirdScreenFragment
import com.example.foodDelivery.ui.restaurantList.RestaurantListFragment


private const val FRAGMENT_COUNT = 3

class HomeViewPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int =FRAGMENT_COUNT

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> RestaurantListFragment()
            1 -> RestaurantListFragment()
            2 -> RestaurantListFragment()
            else -> RestaurantListFragment()
        }
    }
}
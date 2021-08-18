package com.example.foodDelivery.ui

import androidx.fragment.app.Fragment
import com.example.foodDelivery.data.entity.meal.Meal
import com.example.foodDelivery.data.entity.restaurant.Restaurant

open class BaseFragment: Fragment(),IOnClickListener {

    override fun onClick(restaurant: Restaurant) {
    }

    override fun onClickMeal(meal: Meal) {
    }
}
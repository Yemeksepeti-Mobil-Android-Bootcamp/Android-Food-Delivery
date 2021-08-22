package com.example.foodDelivery.ui.restaurantDetail

import com.example.foodDelivery.data.entity.meal.Meal

interface IMealListener {
    fun onClickMeal(meal: Meal)

    fun onClickOrder(meal: Meal)

}
package com.example.foodDelivery.ui

import com.example.foodDelivery.data.entity.meal.Meal
import com.example.foodDelivery.data.entity.restaurant.Restaurant

 interface IOnClickListener {
     fun onClick(restaurant:Restaurant)

     fun onClickMeal(restaurant:Meal)
}
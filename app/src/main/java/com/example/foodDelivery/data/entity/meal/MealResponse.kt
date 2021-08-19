package com.example.foodDelivery.data.entity.meal

import com.google.gson.annotations.SerializedName

data class MealResponse(
    val `data`: Meal,
    val success: Boolean
)

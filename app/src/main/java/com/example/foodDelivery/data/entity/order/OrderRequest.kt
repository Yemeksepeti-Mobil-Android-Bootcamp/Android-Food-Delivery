package com.example.foodDelivery.data.entity.order

import com.google.gson.annotations.SerializedName

data class OrderRequest(
    @SerializedName("restaurantId")
    val restaurantId: String,
    @SerializedName("mealId")
    val mealId: String,
)
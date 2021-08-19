package com.example.foodDelivery.data.entity.order

import com.google.gson.annotations.SerializedName

data class OrderResponse(

    @SerializedName("success")
    val success: Boolean
)
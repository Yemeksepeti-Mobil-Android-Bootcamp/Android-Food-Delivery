package com.example.foodDelivery.data.entity.order

import com.google.gson.annotations.SerializedName

data class OrderGetResponse(
    @SerializedName("data")
    val orderList: ArrayList<Order>,
    val success: Boolean
)
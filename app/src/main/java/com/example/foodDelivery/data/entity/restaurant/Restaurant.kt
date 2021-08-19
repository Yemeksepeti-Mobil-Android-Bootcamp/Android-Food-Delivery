package com.example.foodDelivery.data.entity.restaurant

import com.example.foodDelivery.data.entity.meal.Meal
import com.example.foodDelivery.utils.room.entity.LocalRestaurant
import com.google.gson.annotations.SerializedName

data class Restaurant(
    @SerializedName("_id")
    val id: String,
    @SerializedName("deliveryInfo")
    val deliveryInfo: String,
    @SerializedName("deliveryTime")
    val deliveryTime: String,
    @SerializedName("imageUrl")
    val image: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("district")
    val district: String,
    @SerializedName("meals")
    val meals: ArrayList<Meal>,
    @SerializedName("minDeliveryFee")
    val minimumDeliveryFee: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("paymentMethods")
    val paymentMethods: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("website")
    val website: String,
    @SerializedName("cuisine")
    val cuisine: String,
){
    fun toLocalRestaurant(): LocalRestaurant {
        return LocalRestaurant(restaurantId =id,deliveryInfo = deliveryInfo,deliveryTime = deliveryTime,image = image,address = address,name = name,phone = phone,
            website = website,minDeliveryFee = minimumDeliveryFee,paymentMethods = paymentMethods,imageUrl = image)
    }
}
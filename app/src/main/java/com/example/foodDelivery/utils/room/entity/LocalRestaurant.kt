package com.example.foodDelivery.utils.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "LocalRestaurant")
data class LocalRestaurant (
    @PrimaryKey var restaurantId:String,
    @ColumnInfo(name = "deliveryInfo")var deliveryInfo: String,
    @ColumnInfo(name = "deliveryTime")var deliveryTime: String,
    @ColumnInfo(name = "image")var image: String,
    @ColumnInfo(name = "address")var address: String,
    @ColumnInfo(name = "name")var name: String,
    @ColumnInfo(name = "phone")var phone: String,
    @ColumnInfo(name = "website")var website: String,
    @ColumnInfo(name = "minDeliveryFee")var minDeliveryFee: String,
    @ColumnInfo(name = "paymentMethods")var paymentMethods: String,
    @ColumnInfo(name = "imageUrl")var imageUrl: String,
)
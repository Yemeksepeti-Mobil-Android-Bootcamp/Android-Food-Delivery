package com.example.foodDelivery.data.entity.common

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("email")
    val email: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("role")
    val role: String
)//{
//    fun toLocalUser(): LocalUser {
//        return LocalUser(name = name, email = email, role = role)
//    }
//}
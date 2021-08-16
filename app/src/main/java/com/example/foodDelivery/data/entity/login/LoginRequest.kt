package com.example.foodDelivery.data.entity.login

import com.google.gson.annotations.SerializedName

class LoginRequest {

    data class LoginRequest(
        @SerializedName("email")
        val email: String,
        @SerializedName("password")
        val password: String
    )
}
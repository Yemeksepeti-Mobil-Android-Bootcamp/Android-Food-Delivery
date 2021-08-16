package com.example.foodDelivery.data.remote

import com.example.foodDelivery.data.entity.login.LoginRequest
import com.example.foodDelivery.data.entity.login.LoginResponse
import com.example.foodDelivery.data.entity.register.RegisterRequest
import com.example.foodDelivery.data.entity.register.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface NetworkApiService {

    @POST("auth/register")
    suspend fun register(@Body request: RegisterRequest): Response<RegisterResponse>

    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
}
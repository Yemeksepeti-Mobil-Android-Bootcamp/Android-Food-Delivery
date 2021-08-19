package com.example.foodDelivery.data.remote

import com.example.foodDelivery.data.entity.login.LoginRequest
import com.example.foodDelivery.data.entity.login.LoginResponse
import com.example.foodDelivery.data.entity.meal.MealResponse
import com.example.foodDelivery.data.entity.order.OrderGetResponse
import com.example.foodDelivery.data.entity.order.OrderRequest
import com.example.foodDelivery.data.entity.order.OrderResponse
import com.example.foodDelivery.data.entity.register.RegisterRequest
import com.example.foodDelivery.data.entity.register.RegisterResponse
import com.example.foodDelivery.data.entity.restaurant.RestaurantListResponse
import com.example.foodDelivery.data.entity.restaurant.RestaurantResponse
import com.example.foodDelivery.data.entity.user.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface NetworkApiService {

    @POST("auth/register")
    suspend fun register(@Body request: RegisterRequest): Response<RegisterResponse>

    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @GET("a/restaurant")
    suspend fun getRestaurants(): Response<RestaurantListResponse>

    @GET("a/restaurant/{id}")
    suspend fun getRestaurantById(@Path("id") id: String): Response<RestaurantResponse>

    @GET("a/meal/{id}")
    suspend fun getMealById(@Path("id") id: String): Response<MealResponse>

    @GET("auth/profile")
    suspend fun getUser() : Response<UserResponse>

    @POST("a/order")
    suspend fun postOrder(@Body request: OrderRequest): Response<OrderResponse>

    @GET("a/order")
    suspend fun getOrders(): Response<OrderGetResponse>

}
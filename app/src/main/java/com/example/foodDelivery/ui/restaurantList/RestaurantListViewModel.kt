package com.example.foodDelivery.ui.restaurantList

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.foodDelivery.data.Repository
import com.example.foodDelivery.data.entity.restaurant.Restaurant
import com.example.foodDelivery.data.entity.restaurant.RestaurantListResponse
import com.example.foodDelivery.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RestaurantListViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: Repository
):ViewModel() {

    lateinit var restaurantList: List<Restaurant>

    fun getRestaurants(): LiveData<Resource<RestaurantListResponse>> =
        repository.getRestaurants()
}
package com.example.foodDelivery.ui.restaurantDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.foodDelivery.data.Repository
import com.example.foodDelivery.data.entity.order.OrderRequest
import com.example.foodDelivery.data.entity.order.OrderResponse
import com.example.foodDelivery.data.entity.restaurant.RestaurantResponse
import com.example.foodDelivery.utils.Resource
import com.example.foodDelivery.utils.room.entity.LocalRestaurant
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RestaurantDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: Repository
):ViewModel() {

    fun getRestaurant(): LiveData<Resource<RestaurantResponse>> =
        savedStateHandle.get<String>("restaurantId")!!.let {
            repository.getRestaurantById(it)
        }

    fun addFavorite(localRestaurant: LocalRestaurant){
        repository.addFavorite(localRestaurant)
    }

    fun postOrder(orderRequest: OrderRequest):LiveData<Resource<OrderResponse>> = repository.postOrder(orderRequest)
}
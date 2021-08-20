package com.example.foodDelivery.ui.restaurantList

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.foodDelivery.data.Repository
import com.example.foodDelivery.data.entity.restaurant.Restaurant
import com.example.foodDelivery.data.entity.restaurant.RestaurantListResponse
import com.example.foodDelivery.utils.Resource
import com.example.foodDelivery.utils.room.entity.LocalRestaurant
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RestaurantListViewModel @Inject constructor(
    private val repository: Repository
):ViewModel() {

    lateinit var restaurantList: List<Restaurant>

    fun getRestaurants(): LiveData<Resource<RestaurantListResponse>> =
        repository.getRestaurants()

    fun addFavorite(localRestaurant: LocalRestaurant){
        repository.addFavorite(localRestaurant)
    }

    fun filterList(text: String?): List<Restaurant>? {
        if (text.isNullOrEmpty())
            return restaurantList

        val filterList: MutableList<Restaurant> = mutableListOf()
        restaurantList?.forEach { restaurant ->
            if (restaurant.address.contains(text, true))
                filterList.add(restaurant)
        }
        return filterList
    }

}
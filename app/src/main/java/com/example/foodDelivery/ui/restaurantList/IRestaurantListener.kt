package com.example.foodDelivery.ui.restaurantList

import com.example.foodDelivery.data.entity.restaurant.Restaurant

interface IRestaurantListener {
     fun onClick(restaurant: Restaurant) {
    }

     fun onFavoriteClick(restaurant: Restaurant) {
    }
}
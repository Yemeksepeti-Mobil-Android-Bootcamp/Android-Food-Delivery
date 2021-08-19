package com.example.foodDelivery.ui.favorite

import com.example.foodDelivery.utils.room.entity.LocalRestaurant

interface IFavoriteListener {

    fun onClick(localRestaurant: LocalRestaurant)

    fun onClickFavButton(localRestaurant: LocalRestaurant)
}
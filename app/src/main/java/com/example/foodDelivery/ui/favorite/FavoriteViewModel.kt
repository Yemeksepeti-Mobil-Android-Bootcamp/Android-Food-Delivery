package com.example.foodDelivery.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodDelivery.data.Repository
import com.example.foodDelivery.utils.room.entity.LocalRestaurant
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private var favoriteList = MutableLiveData<List<LocalRestaurant>>()
    fun getFavoriteListLiveData(): LiveData<List<LocalRestaurant>> = favoriteList

    fun listFavorite() {
        favoriteList.value = repository.listFavorite()
    }

    fun removeFavorite(localRestaurant: LocalRestaurant){
        repository.removeFavorite(localRestaurant)
    }

}
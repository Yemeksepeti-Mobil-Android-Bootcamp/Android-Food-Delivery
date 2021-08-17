package com.example.foodDelivery.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.foodDelivery.data.Repository
import com.example.foodDelivery.data.entity.login.LoginRequest
import com.example.foodDelivery.data.entity.login.LoginResponse
import com.example.foodDelivery.utils.Resource
import com.example.foodDelivery.utils.room.LocalUser
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: Repository
):ViewModel() {
    private var navigationLiveData = MutableLiveData<LocalUser>()
    fun observeNavigationLiveData(): LiveData<LocalUser> = navigationLiveData

    fun getUser(userId: Int = 0){
        navigationLiveData.value = repository.getUser(userId)
    }
}
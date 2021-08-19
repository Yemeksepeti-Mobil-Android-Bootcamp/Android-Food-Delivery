package com.example.foodDelivery.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.foodDelivery.data.Repository
import com.example.foodDelivery.data.entity.user.UserResponse
import com.example.foodDelivery.utils.Resource
import com.example.foodDelivery.utils.room.entity.LocalUser
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: Repository
):ViewModel() {

    private var userLiveData = MutableLiveData<LocalUser>()
    fun observeUserLiveData(): LiveData<LocalUser> = userLiveData

    fun getProfileInformation() {
        userLiveData.value =repository.getUserDb()
    }

    fun logout(user:LocalUser){
        repository.logout(user)
    }
}
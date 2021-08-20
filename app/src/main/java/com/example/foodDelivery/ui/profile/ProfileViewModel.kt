package com.example.foodDelivery.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodDelivery.data.Repository
import com.example.foodDelivery.utils.room.entity.LocalUser
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: Repository
):ViewModel() {

    private var userLiveData = MutableLiveData<LocalUser>()
    fun observeUserLiveData(): LiveData<LocalUser> = userLiveData

    private var themeLiveData = MutableLiveData<String>()
    fun observeThemeLiveData(): LiveData<String> = themeLiveData

    fun getProfileInformation() {
        userLiveData.value =repository.getUserDb()
    }

    fun logout(user:LocalUser){
        repository.logout(user)
    }

    fun getThemeInfo(){
        themeLiveData.value= repository.getString("theme")
    }

    fun saveThemeInfo(mode:String){
        repository.saveString("theme",mode)
    }
}
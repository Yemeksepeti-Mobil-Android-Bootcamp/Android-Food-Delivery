package com.example.foodDelivery.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodDelivery.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    val repository: Repository
):ViewModel() {
    private var navigationLiveData = MutableLiveData<String>()
    fun observeNavigationLiveData(): LiveData<String> = navigationLiveData

    fun checkAndNavigation(key:String){
        if (!repository.getString(key).isNullOrEmpty()){
            checkToken()
        }

        else {
            navigationLiveData.value = "onboarding"
        }
    }

    private fun checkToken(){
        if (!repository.getString("token").isNullOrEmpty())
            navigationLiveData.value = "home"
        else {
            navigationLiveData.value = "auth"
        }
    }
}
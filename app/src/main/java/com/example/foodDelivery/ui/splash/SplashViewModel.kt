package com.example.foodDelivery.ui.splash

import android.view.AbsSavedState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.foodDelivery.data.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val apiRepository: ApiRepository
):ViewModel() {
    private var navigationLiveData = MutableLiveData<String>()
    fun observeNavigationLiveData(): LiveData<String> = navigationLiveData

    fun checkOnboardingAndNavigation(key:String){
        if (!apiRepository.getString(key).isNullOrEmpty())
            navigationLiveData.value = "auth"
        else {
            navigationLiveData.value = "onboarding"
        }
    }

}
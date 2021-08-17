package com.example.foodDelivery.ui.onboarding

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.foodDelivery.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val repository: Repository
):ViewModel() {

    fun saveOnboardingState(key: String, value:String){
        repository.saveString(key,value)
    }
}
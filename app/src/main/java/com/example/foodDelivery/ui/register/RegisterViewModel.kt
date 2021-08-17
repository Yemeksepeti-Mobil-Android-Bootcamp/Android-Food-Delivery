package com.example.foodDelivery.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.foodDelivery.data.Repository
import com.example.foodDelivery.data.entity.register.RegisterRequest
import com.example.foodDelivery.data.entity.register.RegisterResponse
import com.example.foodDelivery.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: Repository
):ViewModel() {
    fun register(
        email: String,
        name: String,
        password: String
    ):LiveData<Resource<RegisterResponse>>{
        val request = RegisterRequest(email,name,password)
        return repository.register(request)
    }
}
package com.example.foodDelivery.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.foodDelivery.data.Repository
import com.example.foodDelivery.data.entity.login.LoginRequest
import com.example.foodDelivery.data.entity.login.LoginResponse
import com.example.foodDelivery.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: Repository
):ViewModel() {

    fun login(email: String,password:String ):LiveData<Resource<LoginResponse>>{
        val request = LoginRequest(email, password)
        return  repository.login(request)
    }
}
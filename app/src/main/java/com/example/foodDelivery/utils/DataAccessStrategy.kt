package com.example.foodDelivery.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.foodDelivery.data.entity.common.Data
import com.example.foodDelivery.data.entity.login.LoginResponse
import com.example.foodDelivery.data.entity.register.RegisterResponse
import kotlinx.coroutines.Dispatchers


fun <T> performNetworkOperation(call: suspend () -> Resource<T>): LiveData<Resource<T>> {
    return liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val networkCall = call.invoke()
        if (networkCall.status == Resource.Status.SUCCESS) {
            val data = networkCall.data!!
            emit(Resource.success(data))
        } else if (networkCall.status == Resource.Status.ERROR) {
            emit(
                Resource.error(
                    "Error: ${networkCall.message}"
                )
            )
        }
    }
}

fun <T>performAuthNetworkOperation(
    call: suspend () -> Resource<T>,
    saveToken:(token:String)-> Unit,
    saveUser:suspend (data:Data)->Unit
):LiveData<Resource<T>>{
    return liveData(Dispatchers.IO){
        emit(Resource.loading())
        val networkCall = call.invoke()
        if (networkCall.status == Resource.Status.SUCCESS){
            val data = networkCall.data!!
            if (data is LoginResponse) {
                saveToken(data.token)
                saveUser(data.data)
            }else if(data is RegisterResponse){
                saveToken(data.token)
                saveUser(data.data)
            }
            emit(Resource.success(data))
        }else if(networkCall.status == Resource.Status.ERROR){
            emit(
                Resource.error(
                    "Error: ${networkCall.message}"
                )
            )
        }
    }
}


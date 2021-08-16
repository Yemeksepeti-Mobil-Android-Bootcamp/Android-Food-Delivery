package com.example.foodDelivery.data

import com.example.foodDelivery.data.entity.register.RegisterRequest
import com.example.foodDelivery.data.local.LocalDataSource
import com.example.foodDelivery.data.remote.RemoteDataSource
import com.example.foodDelivery.utils.performNetworkOperation
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource:RemoteDataSource
) {
    fun saveString(key:String,value:String){
        localDataSource.saveString(key,value)
    }

    fun getString(key:String): String? {
        return localDataSource.getString(key)
    }

    fun register(registerRequest: RegisterRequest) =
        performNetworkOperation {
            remoteDataSource.postRegister(request = registerRequest)
        }
}
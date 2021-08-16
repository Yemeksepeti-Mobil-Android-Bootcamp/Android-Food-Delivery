package com.example.foodDelivery.data

import com.example.foodDelivery.data.local.LocalDataSource
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private val localDataSource: LocalDataSource
) {
    fun saveString(key:String,value:String){
        localDataSource.saveString(key,value)
    }

    fun getString(key:String): String? {
        return localDataSource.getString(key)
    }
}
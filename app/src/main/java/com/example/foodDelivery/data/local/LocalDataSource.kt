package com.example.foodDelivery.data.local

import javax.inject.Inject

class LocalDataSource@Inject constructor(
    val mmkvManager: MmkvManager,
) {

    fun saveString(key:String,value:String){
       mmkvManager.saveString(key,value)
    }

    fun getString(key:String): String? {
        return mmkvManager.getString(key)
    }
}
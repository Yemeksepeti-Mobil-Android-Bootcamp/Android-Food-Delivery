package com.example.foodDelivery.data.local

import android.util.Log
import com.example.foodDelivery.utils.room.entity.LocalUser
import com.example.foodDelivery.utils.room.DbDao
import com.example.foodDelivery.utils.room.entity.LocalRestaurant
import javax.inject.Inject

class LocalDataSource@Inject constructor(
    val mmkvManager: MmkvManager,
    val dbDao: DbDao
) {

    fun saveString(key:String,value:String){
       mmkvManager.saveString(key,value)
        Log.v("auth" ,value)
    }

    fun getString(key:String): String? {
        return mmkvManager.getString(key)
    }

    fun addUser(localUser: LocalUser){
        dbDao.addUser(localUser)
        Log.v("auth" , localUser.toString())
    }
    fun getUser(userId: Int = 0): LocalUser {
       return dbDao.getUserById(userId)
    }

    fun removeUser(localUser: LocalUser) {
        dbDao.removeUser(localUser)
    }

    fun addFavorite(localeRestaurant: LocalRestaurant){
        dbDao.addFavorite(localeRestaurant)
    }

    fun listFavorite():List<LocalRestaurant>{
        return  dbDao.listFavorite()
    }

    fun removeFavorite(localeRestaurant: LocalRestaurant){
        dbDao.removeFavorite(localeRestaurant)
    }
}

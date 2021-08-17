package com.example.foodDelivery.data.local

import android.util.Log
import com.example.foodDelivery.utils.room.LocalUser
import com.example.foodDelivery.utils.room.UserDao
import javax.inject.Inject

class LocalDataSource@Inject constructor(
    val mmkvManager: MmkvManager,
    val userDao: UserDao
) {

    fun saveString(key:String,value:String){
       mmkvManager.saveString(key,value)
        Log.v("auth" ,value)
    }

    fun getString(key:String): String? {
        return mmkvManager.getString(key)
    }

    fun addUser(localUser: LocalUser){
        userDao.addUser(localUser)
        Log.v("auth" , localUser.toString())
    }
    fun getUser(userId: Int = 0): LocalUser {
       return userDao.getUserById(userId)
    }

    fun removeUser(localUser: LocalUser) {
        userDao.removeUser(localUser)
    }
}

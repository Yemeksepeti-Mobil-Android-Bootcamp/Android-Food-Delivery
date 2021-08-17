package com.example.foodDelivery.data

import com.example.foodDelivery.data.entity.login.LoginRequest
import com.example.foodDelivery.data.entity.register.RegisterRequest
import com.example.foodDelivery.data.local.LocalDataSource
import com.example.foodDelivery.data.remote.RemoteDataSource
import com.example.foodDelivery.utils.performAuthNetworkOperation
import com.example.foodDelivery.utils.room.LocalUser
import javax.inject.Inject

class Repository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {
    fun saveString(key: String, value: String) {
        localDataSource.saveString(key, value)
    }

    fun getString(key: String): String? {
        return localDataSource.getString(key)
    }

    fun register(registerRequest: RegisterRequest) =
        performAuthNetworkOperation(
            call = {
                remoteDataSource.postRegister(request = registerRequest)
            },
            saveToken = {
                localDataSource.saveString("token",it)
            },
            saveUser = {
                val user = it.toLocalUser()
                localDataSource.addUser(user)
            }
            )

    fun login(loginRequest: LoginRequest) = performAuthNetworkOperation (
        call = {
            remoteDataSource.postLogin(loginRequest)
        },
        saveToken = {
            localDataSource.saveString("token",it)
        },
        saveUser = {
            val user = it.toLocalUser()
            localDataSource.addUser(user)
        }
    )

    fun getUser(userId: Int = 0): LocalUser {
        return localDataSource.getUser(userId)
    }

    fun removeUsers(localUser: LocalUser) {
        localDataSource.removeUser(localUser)
    }

//    fun removeToken() {
//        localDataSource.saveString("token", "")
//    }
}
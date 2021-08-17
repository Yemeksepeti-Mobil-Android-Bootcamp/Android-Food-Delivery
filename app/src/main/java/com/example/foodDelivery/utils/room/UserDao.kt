package com.example.foodDelivery.utils.room

import androidx.room.*
import androidx.room.Dao

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user: LocalUser)

    @Query("SELECT * FROM localuser WHERE userId=:userId LIMIT 1")
    fun getUserById(userId: Int = 0): LocalUser

    @Delete
    fun removeUser(user: LocalUser)
}
package com.example.foodDelivery.utils.room

import androidx.room.*
import androidx.room.Dao
import com.example.foodDelivery.utils.room.entity.LocalRestaurant
import com.example.foodDelivery.utils.room.entity.LocalUser

@Dao
interface DbDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user: LocalUser)

    @Query("SELECT * FROM LocalUser WHERE userId=:userId LIMIT 1")
    fun getUserById(userId: Int = 0): LocalUser

    @Delete
    fun removeUser(user: LocalUser)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addFavorite(restaurant: LocalRestaurant)

    @Query("SELECT * FROM LocalRestaurant")
    fun listFavorite(): List<LocalRestaurant>


    @Delete
    fun removeFavorite(restaurant: LocalRestaurant)

}
package com.example.foodDelivery.utils.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.foodDelivery.utils.room.entity.LocalRestaurant
import com.example.foodDelivery.utils.room.entity.LocalUser

@Database(entities = [LocalUser::class,LocalRestaurant::class],version = 2)
abstract class AppDatabase:RoomDatabase() {
    abstract fun dbDao():DbDao
}
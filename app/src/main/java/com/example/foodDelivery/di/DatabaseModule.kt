package com.example.foodDelivery.di

import android.content.Context
import androidx.room.Room
import com.example.foodDelivery.data.local.LocalDataSource
import com.example.foodDelivery.data.local.MmkvManager
import com.example.foodDelivery.utils.room.AppDatabase
import com.example.foodDelivery.utils.room.DbDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(
    ActivityRetainedComponent::class
)
class DatabaseModule {

    @Provides
    fun mmkvManager(@ApplicationContext context: Context):MmkvManager {
        return MmkvManager(context)
    }

    @Provides
    fun localDataSource(mmkvManager: MmkvManager, dbDao: DbDao):LocalDataSource {
        return LocalDataSource(mmkvManager,dbDao)
    }

    @Provides
    fun provideRoomDb(@ApplicationContext context: Context):AppDatabase{
        return Room
            .databaseBuilder(context,AppDatabase::class.java,"FoodDeliveryDb")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideUserDao(appDatabase: AppDatabase): DbDao {
        return appDatabase.dbDao()
    }


}
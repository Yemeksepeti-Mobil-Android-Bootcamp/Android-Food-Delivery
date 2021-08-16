package com.example.foodDelivery.di

import android.content.Context
import com.example.foodDelivery.data.local.LocalDataSource
import com.example.foodDelivery.data.local.MmkvManager
import com.tencent.mmkv.MMKV
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
    fun localDataSource(mmkvManager: MmkvManager):LocalDataSource {
        return LocalDataSource(mmkvManager)
    }


}
package com.example.foodDelivery.di

import com.example.foodDelivery.BuildConfig
import com.example.foodDelivery.data.local.LocalDataSource
import com.example.foodDelivery.data.remote.NetworkApiService
import com.example.foodDelivery.data.remote.RemoteDataSource
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(
    SingletonComponent::class
)
class NetworkModule {

    @Provides
    fun provideRemoteDataSource(
        apiService: NetworkApiService,
    ):RemoteDataSource{
        return RemoteDataSource(apiService)
    }

    @Provides
    fun provideApiService(retrofit: Retrofit):NetworkApiService{
        return retrofit.create(NetworkApiService::class.java)
    }

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gson: Gson,
        endpoint:EndPoint
    ):Retrofit{
        return Retrofit.Builder()
            .baseUrl(endpoint.url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideOkHttpClient (localDataSource: LocalDataSource):OkHttpClient{
        var builder = OkHttpClient.Builder()
        builder.interceptors().add(HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG)HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        })
        val token = localDataSource.getString("token")
        if(!token.isNullOrEmpty()){
            builder.addInterceptor{
                val request = it.request().newBuilder().addHeader("Authorization", token).build()
                it.proceed(request)
            }
        }
        return  builder.build()
    }

    @Provides
    fun provideGson():Gson{
        return Gson()
    }

    @Provides
    fun provideEndPoint(): EndPoint {
        return EndPoint("https://dist-learn.herokuapp.com/api/")
    }


}
data class EndPoint(val url: String)

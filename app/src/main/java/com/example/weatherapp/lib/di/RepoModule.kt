package com.example.weatherapp.lib.di

import android.content.Context
import androidx.room.PrimaryKey
import com.example.weatherapp.lib.network.OkHTTP
import com.example.weatherapp.lib.weather.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import okhttp3.OkHttpClient
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
class RepoModule {

    @Singleton
    @Provides
    fun providesWeatherRepository(okHttpClient: OkHTTP) =
        WeatherRepository(okHttpClient)

    @Singleton
    @Provides
    fun providesOkHttpClient() = OkHttpClient()

    @Singleton
    @Provides
    fun providesCoroutineScope() = CoroutineScope(SupervisorJob() + Dispatchers.IO)
}
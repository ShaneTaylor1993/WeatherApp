package com.example.weatherapp.lib.weather

import com.example.weatherapp.lib.model.WeatherData
import com.example.weatherapp.lib.network.OkHTTP
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepository @Inject constructor(
    private val client: OkHTTP
) {
    suspend fun getWeather(url: String): Flow<WeatherData> {
        return withContext(Dispatchers.IO) {
            client.get(url)
        }
    }
}
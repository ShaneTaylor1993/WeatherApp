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

    suspend fun getWeather(): Flow<WeatherData> {
        return withContext(Dispatchers.IO) {
            client.get("https://api.openweathermap.org/data/2.5/weather?lat=38.8951&lon=-77.0364&appid=4ca77a9b4447acf0dad7dc5908983acc")
        }
    }
}
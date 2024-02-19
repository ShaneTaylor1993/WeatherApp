package com.example.weatherapp.lib.network

import com.example.weatherapp.lib.model.WeatherData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import javax.inject.Inject

class OkHTTP @Inject constructor(private val client: OkHttpClient){

    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    @Throws(IOException::class)
    suspend fun get(url: String): Flow<WeatherData> = withContext(Dispatchers.IO) {
        val request: Request = Request.Builder()
            .url(url)
            .build()
        val call = client.newCall(request)

        try {
            val response = call.execute()
            if (response.isSuccessful) {
                val body = response.body?.string() ?: ""
                flow {
                    emit(json.decodeFromString(body))
                }
            } else {
                // Handle unsuccessful response (e.g., log error)
                throw IOException("Unsuccessful response: ${response.code}")
            }
        } catch (e: IOException) {
            throw e
        } catch (e: Exception) {
            throw IOException("Unexpected error: ${e.message}", e)
        }
    }
}
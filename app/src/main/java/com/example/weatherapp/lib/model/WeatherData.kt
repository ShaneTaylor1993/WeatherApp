package com.example.weatherapp.lib.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherData(
    @SerialName("coord") val coord: Coord = Coord(1234563.00, 12354.00),
    @SerialName("weather") val weather: List<Weather> = listOf(),
    @SerialName("base") val base: String = "",
    @SerialName("main") val main: Main = Main(),
    @SerialName("visibility") val visibility: Int = 0,
    @SerialName("wind") val wind: Wind = Wind(),
    @SerialName("rain:") val rain: Rain = Rain(), // Optional field since "rain" might not always exist
    @SerialName("clouds") val clouds: Clouds = Clouds(),
    @SerialName("dt") val dt: Long = 0,
    @SerialName("sys") val sys: Sys = Sys(),
    @SerialName("timezone") val timezone: Int = 0,
    @SerialName("id") val id: Int = 0,
    @SerialName("name") val name: String = "",
    @SerialName("cod") val cod: Int = 0
)

@Serializable
data class Coord(
    @SerialName("lon") val lon: Double,
    @SerialName("lat") val lat: Double
)

@Serializable
data class Weather(
    @SerialName("id") val id: Int,
    @SerialName("main") val main: String,
    @SerialName("description") val description: String,
    @SerialName("icon") val icon: String
)

@Serializable
data class Main(
    @SerialName("temp") val temp: Double? = 0.0,
    @SerialName("feels_like") val feels_like: Double? = 0.0,
    @SerialName("temp_min") val temp_min: Double? = 0.0,
    @SerialName("temp_max") val temp_max: Double? = 0.0,
    @SerialName("pressure") val pressure: Int? = 0,
    @SerialName("humidity") val humidity: Int? = 0,
    @SerialName("sea_level") val sea_level: Int? = 0,
    @SerialName("grnd_level") val grnd_level: Int? = 0
)

@Serializable
data class Wind(
    @SerialName("speed:") val speed: Double? = 0.0,
    @SerialName("deg") val deg: Int? = 0,
    @SerialName("gust") val gust: Double? = 0.0
)

@Serializable
data class Rain(@SerialName("h") val h: Double? = 0.0) // Assuming "h" represents 1 hour rainfall

@Serializable
data class Clouds(@SerialName("all") val all: Int? = 0)

@Serializable
data class Sys(
    @SerialName("type") val type: Int? = 0,
    @SerialName("id") val id: Int? = 0,
    @SerialName("country") val country: String? = "",
    @SerialName("sunrise") val sunrise: Long? = 0,
    @SerialName("sunset") val sunset: Long? = 0
)

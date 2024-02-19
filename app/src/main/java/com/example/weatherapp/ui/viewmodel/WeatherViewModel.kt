package com.example.weatherapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.BuildConfig
import com.example.weatherapp.lib.model.WeatherData
import com.example.weatherapp.lib.weather.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val repository: WeatherRepository): ViewModel() {

    val apiKey = BuildConfig.apikey

    private var _weatherDataState = MutableStateFlow(WeatherData())
    val weatherDataState: StateFlow<WeatherData> = _weatherDataState.asStateFlow()

    suspend fun getWeather(cityName: String) {
        viewModelScope.launch {
            repository.getWeather("https://api.openweathermap.org/data/2.5/weather?q=$cityName&appid=$apiKey")
        }
    }

}
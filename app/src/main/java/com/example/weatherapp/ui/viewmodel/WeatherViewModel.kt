package com.example.weatherapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherapp.lib.model.WeatherData
import com.example.weatherapp.lib.weather.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val repository: WeatherRepository): ViewModel() {

    var _weatherDataState = MutableStateFlow(WeatherData())
    val weatherDataState: StateFlow<WeatherData> = _weatherDataState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getWeather().collect {
                _weatherDataState.value = it
            }
        }
    }
//    fun getWeather() {
//        viewModelScope.launch {
//            repository.getWeather().collect {
//                _weatherData.value = it
//            }
//        }
//    }

}
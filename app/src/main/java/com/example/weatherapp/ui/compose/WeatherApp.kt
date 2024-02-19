package com.example.weatherapp.ui.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherapp.ui.viewmodel.WeatherViewModel

@Composable
fun WeatherApp(vm: WeatherViewModel = viewModel()) {

    val weatherData = vm.weatherDataState.collectAsState()

    WeatherScreen(vm::getWeather)

}
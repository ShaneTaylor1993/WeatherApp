package com.example.weatherapp.ui.compose

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.layout.TestModifierUpdaterLayout
import com.example.weatherapp.lib.model.WeatherData

@Composable
fun WeatherScreen(coordinates: String) {
    
    Text(text = coordinates)
    
}
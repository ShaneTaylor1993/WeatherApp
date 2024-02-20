package com.example.weatherapp.ui.navigation

interface Destinations {
    val route: String
}

object Home : Destinations {
    override val route: String = "home"
}

object WeatherInfo : Destinations {
    override val route: String = "weatherInfo"
}
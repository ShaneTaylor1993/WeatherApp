package com.example.weatherapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.weatherapp.ui.compose.HomeScreen
import com.example.weatherapp.ui.compose.WeatherScreen
import com.example.weatherapp.ui.viewmodel.WeatherViewModel

@Composable
fun AppNavHost(navController: NavHostController, vm: WeatherViewModel) {
    NavHost(
        navController = navController,
        startDestination = Home.route
    )
    {
        composable(route = Home.route) {
            HomeScreen(
                onNextClick = {
                    navController.navigateSingleTopTo(WeatherInfo.route)
                },
                vm::getWeather
            )
        }
        composable(
            route = WeatherInfo.route,
        ) {
            WeatherScreen()
        }

    }

}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) { launchSingleTop = true }
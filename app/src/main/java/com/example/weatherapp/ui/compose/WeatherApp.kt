package com.example.weatherapp.ui.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.ui.navigation.AppNavHost
import com.example.weatherapp.ui.theme.WeatherAppTheme
import com.example.weatherapp.ui.viewmodel.WeatherViewModel

@Composable
fun WeatherApp(vm: WeatherViewModel = viewModel()) {

    WeatherAppTheme {
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
           AppNavHost(navController = navController, vm = vm)
        }
    }
}
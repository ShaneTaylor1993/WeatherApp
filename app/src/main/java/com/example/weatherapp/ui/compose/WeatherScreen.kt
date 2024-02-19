package com.example.weatherapp.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.reflect.KSuspendFunction1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherScreen(
    onClick: KSuspendFunction1<String, Unit>
) {
    var cityName = remember { mutableStateOf("") }

    Column {
        TextField(value = cityName.value, onValueChange = { cityName.value = it })
        Button(onClick = {
            val cityName = cityName.value
            if (cityName.isNotEmpty()) {
                CoroutineScope(Dispatchers.IO).launch {
                    onClick(cityName)
                }
            }

        }, content = {
            Text(text = "Submit")
        })
    }
}
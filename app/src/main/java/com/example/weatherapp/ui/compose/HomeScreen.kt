package com.example.weatherapp.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.reflect.KSuspendFunction1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNextClick: () -> Unit = {},
    onClick: KSuspendFunction1<String, Unit>
) {
    var cityName = remember { mutableStateOf("") }

    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(
            value = cityName.value,
            onValueChange = { cityName.value = it },
            placeholder = { Text(text = "Enter City") }
        )
        Button(onClick = {
            onNextClick()
            val cityNameText = cityName.value
            if (cityNameText.isNotEmpty()) {
                CoroutineScope(Dispatchers.IO).launch {
                    onClick(cityNameText)
                }
            }

        }, content = {
            Text(text = "Submit")
        })
    }
}
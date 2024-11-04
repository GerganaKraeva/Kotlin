package com.example.shoppinglistapp

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Exception

class LocationViewModel : ViewModel() {
    private val _location = mutableStateOf<LocationData?>(null)
    val location: State<LocationData?> = _location

    private val _address = mutableStateOf(listOf<GeocodingResult>())
    val address: State<List<GeocodingResult>> = _address

    fun updateLocation(newLocation: LocationData) {
        _location.value = newLocation
    }

    fun fetchAddress(latlng: String) {
        try {
            viewModelScope.launch {
            val result = RetrofitClient.create().getAddressFromCoordinates(
                latlng,
                "AIzaSyCvAVwJjpq9pRJOsSSJJZt-kifu7IxBEHk"
            )
                _address.value = result.result
            }
    } catch ( e: Exception)
    {
        Log.d("res1", "${e.cause} ${e.message}")
    }
}
}
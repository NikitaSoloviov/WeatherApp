package com.example.wetherapp.forecastFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wetherapp.WeatherApp
import com.example.wetherapp.model.Main
import com.example.wetherapp.model.RvData
import com.example.wetherapp.model.RvList
import com.example.wetherapp.model.Weather
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ForecastFragmentViewModel: ViewModel() {

    private val weather = MutableLiveData<RvList>()
    val weatherLiveData: LiveData<RvList> = weather

    fun dataConvert() {
        viewModelScope.launch  (Dispatchers.IO) {
            val listOfWeather = mutableListOf<RvData>()
            WeatherApp.db.fetchAll().forEachIndexed{ index, weatherEntity ->
                val model = RvData(
                   mutableListOf(Weather(weatherEntity.main, weatherEntity.description)),
                    Main(weatherEntity.temp, weatherEntity.feelsLike)
                )
                     listOfWeather.add(model)
            }
            weather.postValue(RvList(200, 0,  listOfWeather))
        }
    }
}

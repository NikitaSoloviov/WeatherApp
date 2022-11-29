package com.example.wetherapp.mainFragment


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wetherapp.WeatherApp
import com.example.wetherapp.cache.WeatherEntity
import com.example.wetherapp.model.RvData
import com.example.wetherapp.model.RvList
import com.example.wetherapp.network.Constants
import com.example.wetherapp.network.OnApiResultCallBack
import com.example.wetherapp.network.RestApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.*
import java.lang.Exception

class HomeFragmentViewModel : ViewModel() {

    private val listOfWeather = MutableLiveData<List<RvData>>()

    fun getWeather(): LiveData<List<RvData>> = listOfWeather

    fun fetchData(etCityName: String) {
        RestApiService.instance?.getWeather(etCityName, Constants.API_KEY, object : OnApiResultCallBack<RvList>{
            override fun onSuccess(response: RvList) {

                viewModelScope.launch(Dispatchers.IO) {
                    WeatherApp.db.deleteAll()
                    response.list.forEachIndexed{ index, rvData ->
                        val entity = WeatherEntity(
                            rvData.main.temp,
                            rvData.weather.first().main,
                            rvData.main.feelsLike,
                            rvData.weather.first().description
                        )
                        WeatherApp.db.saveOne(entity)
                    }
                }
            }

            override fun onFail(exception: Exception, code: Int) {
                Log.i("test3", "$exception")
            }
        })
    }
}



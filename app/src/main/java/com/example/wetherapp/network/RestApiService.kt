package com.example.wetherapp.network

import android.util.Log
import com.example.wetherapp.model.RvData
import com.example.wetherapp.model.RvList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


class RestApiService private constructor() {

    companion object {
        var instance: RestApiService? = null
            get() {
                if (field == null) {
                    field = RestApiService()
                }
                return field
            }
    }

    private val api: WeatherService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create()
    }

    fun getWeather(q: String, appId: String, onResultCallback: OnApiResultCallBack<RvList>) {

        api.getWeather(q, appId).enqueue(
            object : Callback<RvList> {
                override fun onResponse(
                    call: Call<RvList>,
                    response: Response<RvList>
                ) {
                    if (response.isSuccessful) {

                        val responseList = response.body()
                        if (responseList != null){
                            onResultCallback.onSuccess(responseList)
                        }
                        Log.i("test", "$responseList, ${response.code()}")

                    } else {
                        when (response.code()) {
                            400 -> {
                                Log.e("Error 400", "Bad Connction")
                            }
                            404 -> {
                                Log.e("Error 404", "Not Found")
                            }
                            else -> {
                                Log.e("Error", "Generic Error")
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<RvList>, t: Throwable) {

                    Log.i("test", t.stackTraceToString())
                }
            }
        )
    }
}
package com.example.wetherapp.forecastFragment

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.wetherapp.databinding.WeatherCellBinding
import com.example.wetherapp.model.RvData
import com.example.wetherapp.model.Weather

class ForecastViewHolder(view: View) :
    RecyclerView.ViewHolder(view) {

    private val binding = WeatherCellBinding.bind(view)

    fun bind(weather: RvData, onClick: ((RvData) -> Unit)? = null) {
        binding.root.setOnClickListener {
            onClick?.invoke(weather)
        }
        binding.tvWeather.text = weather.weather.first().main
        binding.tvTempNum.text = weather.main.temp.toString()
    }
}

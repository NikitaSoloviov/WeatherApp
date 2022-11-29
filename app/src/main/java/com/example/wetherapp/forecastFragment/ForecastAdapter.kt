package com.example.wetherapp.forecastFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wetherapp.R
import com.example.wetherapp.model.RvData
import com.example.wetherapp.model.Weather

class ForecastAdapter: RecyclerView.Adapter<ForecastViewHolder>() {

    var onItemClicked: ((RvData) -> Unit)? = null

    var items = mutableListOf<RvData>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.weather_cell, parent, false)
        return ForecastViewHolder(view)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(items[position], onItemClicked)
    }

    override fun getItemCount(): Int = items.size
}
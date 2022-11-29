package com.example.wetherapp.forecastFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.wetherapp.R
import com.example.wetherapp.databinding.FragmentForecastBinding
import com.example.wetherapp.detailedInfoFragment.DetailedInfoFragment
import com.example.wetherapp.model.RvData

class ForecastFragment: Fragment(R.layout.fragment_forecast) {

    companion object {
        const val TAG = "ForecastFragment"
    }

    private val viewModel: ForecastFragmentViewModel = ForecastFragmentViewModel()
    private lateinit var binding: FragmentForecastBinding

    private var adapter = ForecastAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentForecastBinding.bind(
            super.onCreateView(
                inflater,
                container,
                savedInstanceState
            )!!
        )

        setupAdapter()
        initRecyclerView()
        return binding.root
    }

    private fun initRecyclerView() {
        viewModel.dataConvert()
        viewModel.weatherLiveData.observe(viewLifecycleOwner) { listOfWeather ->
            Log.i("test2", "$listOfWeather")
            adapter.items = listOfWeather.list.toMutableList()
        }
    }

    private fun adapterOnClick(model: RvData ) {

        parentFragmentManager.commit {
            replace(R.id.fragmentContainer, DetailedInfoFragment(model), DetailedInfoFragment.TAG)
        }
    }

    private fun setupAdapter() {
        binding.rvWeather.adapter = adapter

        adapter.onItemClicked = ::adapterOnClick

    }
}
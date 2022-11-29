package com.example.wetherapp.mainFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.wetherapp.R
import com.example.wetherapp.databinding.FragmentHomeBinding

import com.example.wetherapp.forecastFragment.ForecastFragment

class HomeFragment: Fragment(R.layout.fragment_home) {

    companion object{
        const val TAG = "AddAuthorFragment"
    }
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeFragmentViewModel = HomeFragmentViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.bind(super.onCreateView(inflater, container, savedInstanceState)!!)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getWeather()
        setupListeners()
    }

    private fun setupListeners() {

        binding.btnLookup.setOnClickListener {
            viewModel.fetchData(binding.etCityName.text.toString())
            parentFragmentManager.commit {
                replace(R.id.fragmentContainer, ForecastFragment(), ForecastFragment.TAG)
            }
        }
    }
}
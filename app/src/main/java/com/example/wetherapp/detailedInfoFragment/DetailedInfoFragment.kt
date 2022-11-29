package com.example.wetherapp.detailedInfoFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wetherapp.R
import com.example.wetherapp.databinding.FragmentDetailedInfoBinding
import com.example.wetherapp.model.RvData

class DetailedInfoFragment(private val item :RvData) : Fragment(R.layout.fragment_detailed_info) {

    companion object {
        const val TAG = "Detailed Info Fragment"
    }

    private var viewModel = DetailedInfoViewModel()
    private lateinit var binding: FragmentDetailedInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailedInfoBinding.bind(
            super.onCreateView(
                inflater,
                container,
                savedInstanceState
            )!!
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViews()
    }

    private fun setViews() {

        binding.tvTemp.text = item.main.temp.toString()
        binding.tvFeelsLikeNum.text = item.main.feelsLike.toString()
        binding.tvWeatherInfo.text = item.weather.first().description
    }
}
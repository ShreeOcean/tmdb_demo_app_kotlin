package com.ocean.demokotlinretrofit.view.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ocean.demokotlinretrofit.R
import com.ocean.demokotlinretrofit.adapter.MainParentAdapter
import com.ocean.demokotlinretrofit.databinding.FragmentHomeBinding
import com.ocean.demokotlinretrofit.viewModel.TrendingDayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val trendingAllViewModel by viewModels<TrendingDayViewModel>()
    private lateinit var mainAdapter: MainParentAdapter


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        //code goes here
        trendingAllViewModel.getTrendingAllData()
        trendingAllViewModel.getTrendingTvData()
        trendingAllViewModel.getTrendingMovieData()
        trendingAllViewModel.getTrendingPeopleData()

        mainAdapter = MainParentAdapter()

        binding.rvMainParent.layoutManager = LinearLayoutManager(context)
        binding.rvMainParent.adapter = mainAdapter

        trendingAllViewModel.trendingAllLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                mainAdapter.trendingAllList = it.resultTrendingAll
                binding.progressBarHome.visibility = View.GONE
            } else
                binding.progressBarHome.visibility = View.VISIBLE
        }

        trendingAllViewModel.trendingMovieLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                mainAdapter.trendMovieList = it.resultTrendingMovies
                binding.progressBarHome.visibility = View.GONE
            } else {
                binding.progressBarHome.visibility = View.VISIBLE
            }
        }

        trendingAllViewModel.trendingTvLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                mainAdapter.trendTvlist = it.resultTrendingTv
            } else {
                binding.progressBarHome.visibility = View.VISIBLE
            }
        }

        trendingAllViewModel.trendingPeopleLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                mainAdapter.trendPersonList = it.resultsTrendPeople
            } else {
                binding.progressBarHome.visibility = View.VISIBLE
            }
        }
        return binding.root
    }

}
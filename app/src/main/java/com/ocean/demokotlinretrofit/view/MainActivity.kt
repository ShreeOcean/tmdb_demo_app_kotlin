package com.ocean.demokotlinretrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ocean.demokotlinretrofit.adapter.MainParentAdapter
import com.ocean.demokotlinretrofit.adapter.TrendingTvWeekRVItemAdapter
import com.ocean.demokotlinretrofit.databinding.ActivityMainBinding
import com.ocean.demokotlinretrofit.viewModel.TrendingDayViewModel
import com.ocean.demokotlinretrofit.viewModel.TrendingTvWeekViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var trendingTvWeekVM: TrendingTvWeekViewModel
    private val trendingAllViewModel by viewModels<TrendingDayViewModel>()
    private lateinit var mainAdapter: MainParentAdapter
    private var trendingRVadapter = TrendingTvWeekRVItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        binding.lifecycleOwner = this

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        trendingAllViewModel.getTrendingAllData()
        trendingAllViewModel.getTrendingTvData()
        trendingAllViewModel.getTrendingMovieData()
        trendingAllViewModel.getTrendingPeopleData()
        mainAdapter = MainParentAdapter()
        binding.rvMainParent.layoutManager = LinearLayoutManager(this)
        binding.rvMainParent.adapter = mainAdapter


        trendingAllViewModel.trendingAllLiveData.observe(this) {
            mainAdapter.trendingAllList = it.resultTrendingAll
            mainAdapter.notifyDataSetChanged()
//            var trendingAll = RvAdapterTrendingAll(it.resultTrendingAll)
//            trendingAll.setListTrendAll(it.resultTrendingAll)

        }

        trendingAllViewModel.trendingMovieLiveData.observe(this){
            mainAdapter.trendMovieList = it.resultTrendingMovies
            //main adapter notifyDataSetChange()
        }

        trendingAllViewModel.trendingTvLiveData.observe(this){
            mainAdapter.trendTvlist = it.resultTrendingTv
        }

        trendingAllViewModel.trendingPeopleLiveData.observe(this){
            mainAdapter.trendPersonList = it.resultsTrendPeople
        }
    }

}
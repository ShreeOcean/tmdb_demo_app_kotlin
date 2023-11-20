package com.ocean.demokotlinretrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
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
    private lateinit var mainAdapter : MainParentAdapter
    private var trendingRVadapter = TrendingTvWeekRVItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        binding.lifecycleOwner = this

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        trendingAllViewModel.getTrendingAllData()
        mainAdapter = MainParentAdapter()
        binding.rvMainParent.adapter = mainAdapter


        trendingAllViewModel.trendingAllLiveData.observe(this){
            Log.d("ListSize__", it.resultTrendingAll.size.toString())
            mainAdapter.trendingAllList = it.resultTrendingAll
            mainAdapter.notifyDataSetChanged()
//            var trendingAll = RvAdapterTrendingAll(it.resultTrendingAll)
//            trendingAll.setListTrendAll(it.resultTrendingAll)

        }
    }

}
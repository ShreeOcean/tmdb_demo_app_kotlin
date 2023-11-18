package com.ocean.demokotlinretrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.ocean.demokotlinretrofit.adapter.MainParentAdapter
import com.ocean.demokotlinretrofit.adapter.RvAdapterTrendingAll
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
    private var mainAdapter = MainParentAdapter()
    private var trendingRVadapter = TrendingTvWeekRVItemAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        binding.lifecycleOwner = this

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        trendingAllViewModel.getTrendingAllData()

        trendingAllViewModel.trendingAllLiveData.observe(this){
            try {

                val adapter = RvAdapterTrendingAll(it.resultTrendingAll)
                //todo: set trendAllAdapter here
                Log.d("TAG-ResponseBody", "onCreate: ${it.resultTrendingAll}")
            }catch (e : Exception){
                Log.d("TAG", "onCreate: Error fetching data: ${e.message}", e)
            }
        }

    }

}
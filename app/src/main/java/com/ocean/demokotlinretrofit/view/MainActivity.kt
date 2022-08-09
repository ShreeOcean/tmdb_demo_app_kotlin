package com.ocean.demokotlinretrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DividerItemDecoration
import com.ocean.demokotlinretrofit.R
import com.ocean.demokotlinretrofit.adapter.TrendingTvWeekRVItemAdapter
import com.ocean.demokotlinretrofit.databinding.ActivityMainBinding
import com.ocean.demokotlinretrofit.model.TrendingTVWeekModel
import com.ocean.demokotlinretrofit.retrofit.RetrofitNetwork
import com.ocean.demokotlinretrofit.viewModel.TrendingTvWeekViewModel

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    lateinit var binding: ActivityMainBinding
    lateinit var trendingTvWeekViewModel: TrendingTvWeekViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        val rvAdapterTrendingTvWeek  = TrendingTvWeekRVItemAdapter(this)
        binding.rvResultTrending.adapter = rvAdapterTrendingTvWeek
        binding.rvResultTrending.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        trendingTvWeekViewModel.trendingTvWeekVM.observe(this) {
            rvAdapterTrendingTvWeek.update(it)
        }


    }

}
package com.ocean.demokotlinretrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.ocean.demokotlinretrofit.R
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
    private val trendinAllViewModel by viewModels<TrendingDayViewModel>()
    private var mainAdapter = MainParentAdapter()
    private var trendingRVadapter = TrendingTvWeekRVItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        binding.lifecycleOwner = this

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        trendinAllViewModel.trendingAllLiveData.observe(this){
            try {
//                val adapter = CarAdapter(it.data)
//                binding.recycleView.adapter = adapter
                Log.d("TAG-ResponseBody", "onCreate: ${it.resultTrendingAll}")
            }catch (e : Exception){
                Log.d("TAG", "onCreate: Error fetching data: ${e.message}", e)
            }
        }
       /* trendingTvWeekVM = ViewModelProvider(this)[TrendingTvWeekViewModel::class.java]
        binding.viewModel = trendingTvWeekVM
        binding.lifecycleOwner = this

        trendingTvWeekVM.getDataForTrendTvWeek()

        trendingTvWeekVM.trendingTVWeekResponse.observe(this) {
            if (it != null) {
                trendingRVadapter.setListTrendTv(it.results)
                //TODO: how to initialize nested recycler view here or later
            }
        }

//        val rvAdapterTrendingTvWeek  = TrendingTvWeekRVItemAdapter(this)
//        binding.rvMainParent.adapter = rvAdapterTrendingTvWeek
//        binding.rvMainParent.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
*/


    }

}
package com.ocean.demokotlinretrofit.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ocean.demokotlinretrofit.model.ResultsTrendingTvWeekModel
import com.ocean.demokotlinretrofit.model.TrendingTVWeekModel
import com.ocean.demokotlinretrofit.retrofit.TrendingRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TrendingTvWeekViewModel : ViewModel(){

    val trendingTvWeekVM = MutableLiveData<List<ResultsTrendingTvWeekModel>>()

    var trendingTVWeekResponse = MutableLiveData<Boolean>()

    init {
        getData()
        trendingTVWeekResponse.value =false
    }

    private fun getData() {

        CoroutineScope(Dispatchers.IO).launch {
            val trendingTvData = TrendingRepo.getTrendingTvWeek().body()?.results
            withContext(Dispatchers.Main){
                trendingTvWeekVM.value = trendingTvData!!
            }
        }
    }

    fun seeAllTrendingTv(){
        trendingTVWeekResponse.value = true
    }


}
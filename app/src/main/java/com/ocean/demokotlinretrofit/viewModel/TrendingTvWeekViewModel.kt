package com.ocean.demokotlinretrofit.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ocean.demokotlinretrofit.baseClasses.BaseViewModel
import com.ocean.demokotlinretrofit.model.TrendingResponse
import com.ocean.demokotlinretrofit.repository.TrendingOnDayRepository
import com.ocean.demokotlinretrofit.utility.AppConstants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class TrendingTvWeekViewModel : BaseViewModel(){

    var showProgress : MutableLiveData<Boolean> = MutableLiveData()

    var trendingTvWeekVM : MutableLiveData<TrendingResponse> = MutableLiveData()
    val trendingTVWeekResponse : LiveData<TrendingResponse> get() = trendingTvWeekVM

    private val _errorMsg = MutableLiveData<String>()
    val errorMsg : LiveData<String> get() = _errorMsg

    init {
        showProgress.value =false
    }

    fun getDataForTrendTvWeek() {

        showProgress.value = true

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val trendingResponse = withContext(Dispatchers.IO){
                    TrendingOnDayRepository.getTrendingTvWeek(AppConstants.api_key)
                }
                trendingTvWeekVM.value = trendingResponse.body()

            }catch (e : HttpException){

                showProgress.value = false
                e.message?.let { kotlin.error(it) }

            } catch (e : Exception){

                showProgress.value = false
                e.message?.let { kotlin.error(it) }
                _errorMsg.value = e.message
            }

        }
    }

}
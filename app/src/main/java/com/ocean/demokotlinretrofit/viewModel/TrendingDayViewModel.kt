package com.ocean.demokotlinretrofit.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ocean.demokotlinretrofit.api.APINames
import com.ocean.demokotlinretrofit.model.trendingMovie.TrendingMovieResponse
import com.ocean.demokotlinretrofit.model.trendingPeople.TrendingPeopleResponse
import com.ocean.demokotlinretrofit.model.trendingall.TrendingAllResponse
import com.ocean.demokotlinretrofit.model.trendingtv.TrendingTvResponse
import com.ocean.demokotlinretrofit.repository.TrendingOnDayRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrendingDayViewModel @Inject constructor(private val trendingDayRepository : TrendingOnDayRepository) : ViewModel() {

    val trendingAllLiveData : LiveData<TrendingAllResponse> get() = trendingDayRepository.trendingAllLiveData
    val trendingTvLiveData : LiveData<TrendingTvResponse> get() = trendingDayRepository.trendingTvLiveData_
    val trendingMovieLiveData : LiveData<TrendingMovieResponse> get() = trendingDayRepository.trendingMovieLiveData_

    val trendingPeopleLiveData : LiveData<TrendingPeopleResponse> get() = trendingDayRepository.trendingPeopleLiveData_

    fun getTrendingAllData(){
        viewModelScope.launch {
            trendingDayRepository.getTrendingAll()
        }
    }

    fun getTrendingTvData(){
        viewModelScope.launch {
            trendingDayRepository.getTrendingTv()
        }
    }

    fun getTrendingMovieData(){
        viewModelScope.launch {
            trendingDayRepository.getTrendingMovie()
        }
    }

    fun getTrendingPeopleData(){
        viewModelScope.launch {
            trendingDayRepository.getTrendingPeople()
        }
    }
}
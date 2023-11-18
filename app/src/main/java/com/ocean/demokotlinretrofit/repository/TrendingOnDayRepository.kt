package com.ocean.demokotlinretrofit.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ocean.demokotlinretrofit.api.APINames
import com.ocean.demokotlinretrofit.model.trendingMovie.TrendingMovieResponse
import com.ocean.demokotlinretrofit.model.trendingPeople.TrendingPeopleResponse
import com.ocean.demokotlinretrofit.model.trendingall.TrendingAllResponse
import com.ocean.demokotlinretrofit.model.trendingtv.TrendingTvResponse
import com.ocean.demokotlinretrofit.utility.AppConstants
import javax.inject.Inject

class TrendingOnDayRepository @Inject constructor (private val apiService: APINames){

    private val trendingAllResponse = MutableLiveData<TrendingAllResponse>()
    val trendingAllLiveData : LiveData<TrendingAllResponse> get() = trendingAllResponse

    private val trendingTvResponse = MutableLiveData<TrendingTvResponse>()
    val trendingTvLiveData_ : LiveData<TrendingTvResponse> get() = trendingTvResponse

    private val trendingMovieResponse = MutableLiveData<TrendingMovieResponse>()
    val trendingMovieLiveData_ : LiveData<TrendingMovieResponse> get() = trendingMovieResponse

    private val trendingPeopleResponse = MutableLiveData<TrendingPeopleResponse>()
    val trendingPeopleLiveData_ : LiveData<TrendingPeopleResponse> get() = trendingPeopleResponse

    suspend fun getTrendingAll(){
        val response = apiService.getTrendingAll(AppConstants.language, AppConstants.access_auth_token)

        if(response.isSuccessful && response.body() != null){
            trendingAllResponse.postValue(response.body())
        }//TODO: handle error code goes here
    }

    suspend fun getTrendingMovie(){

        val trendMovieResponse = apiService.getTrendingMovies(AppConstants.language)

        if (trendMovieResponse.isSuccessful && trendMovieResponse.body() != null){
            trendingMovieResponse.postValue(trendMovieResponse.body())
        }//TODO: handle error code goes here
    }

    suspend fun getTrendingTv(){

        val trendTvResponse = apiService.getTrendingTv(AppConstants.language)

        if (trendTvResponse.isSuccessful && trendTvResponse.body() != null){
            trendingTvResponse.postValue(trendTvResponse.body())
        }//TODO: handle error code goes here
    }

    suspend fun getTrendingPeople(){

        val trendPeopleResponse = apiService.getTrendingTv(AppConstants.language)

        if (trendPeopleResponse.isSuccessful && trendPeopleResponse.body() != null){
//            trendingPeopleResponse.postValue(trendPeopleResponse.body())
        }//TODO: handle error code goes here
    }


}
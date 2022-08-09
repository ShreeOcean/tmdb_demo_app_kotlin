package com.ocean.demokotlinretrofit.retrofit

import com.ocean.demokotlinretrofit.model.TrendingTVWeekModel
import com.ocean.demokotlinretrofit.utility.AppConstants.api_key
import retrofit2.Response

object TrendingRepo {

    private val instance = RetrofitNetwork.instance

    suspend fun getTrendingTvWeek(): Response<TrendingTVWeekModel>{
        return instance.getApis().getTrendingTvWeek(api_key)
    }
}
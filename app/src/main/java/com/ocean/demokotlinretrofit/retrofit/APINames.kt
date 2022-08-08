package com.ocean.demokotlinretrofit.retrofit

import com.ocean.demokotlinretrofit.model.TrendingTVWeekModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APINames {

//    Call<TrendingTVResponse> getTrendingTvOfWeek(@Query("api_key") String apikey);

    @GET("/3/trending/tv/week")
    suspend fun getTrendingTvWeek(@Query("api_key") api_key : String) : Response<TrendingTVWeekModel>
}
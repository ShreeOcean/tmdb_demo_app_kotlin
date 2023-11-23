package com.ocean.demokotlinretrofit.api

import com.ocean.demokotlinretrofit.model.TrendingResponse
import com.ocean.demokotlinretrofit.model.trendingMovie.TrendingMovieResponse
import com.ocean.demokotlinretrofit.model.trendingPeople.TrendingPeopleResponse
import com.ocean.demokotlinretrofit.model.trendingall.TrendingAllResponse
import com.ocean.demokotlinretrofit.model.trendingtv.TrendingTvResponse
import com.ocean.demokotlinretrofit.model.trendpersondetails.TrendPersonDetailsResponse
import com.ocean.demokotlinretrofit.utility.AppConstants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface APINames {

    @GET("/3/trending/tv/week")
    suspend fun getTrendingTvWeek(@Query("api_key") api_key: String): Response<TrendingResponse>

    @GET(AppConstants.trendingAllApi)
    suspend fun getTrendingAll(@Query(AppConstants.LANGUAGE_) language: String): Response<TrendingAllResponse>

    @GET(AppConstants.trendingTvApi)
    suspend fun getTrendingTv(
        @Query(AppConstants.LANGUAGE_) language: String
    ): Response<TrendingTvResponse>

    @GET(AppConstants.trendingMovieApi)
    suspend fun getTrendingMovies(
        @Query(AppConstants.LANGUAGE_) language: String
    ): Response<TrendingMovieResponse>

    @GET(AppConstants.trendingPersonApi)
    suspend fun getTrendingPerson(@Query(AppConstants.LANGUAGE_) language: String): Response<TrendingPeopleResponse>

    @GET(AppConstants.trend_person_details)
    suspend fun getTrendPersonDetails(
        @Path(AppConstants.TREND_PERSON_ID) trendPersonId: Int,
        @Query(AppConstants.LANGUAGE_) language: String
    ): Response<TrendPersonDetailsResponse>
}
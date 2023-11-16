package com.ocean.demokotlinretrofit.model.trendingMovie

import com.google.gson.annotations.SerializedName

data class TrendingMovieResponse(
    val page: Int,
    @SerializedName("results") val resultTrendingMovies: List<ResultTrendingMovie>,
    val total_pages: Int,
    val total_results: Int
)
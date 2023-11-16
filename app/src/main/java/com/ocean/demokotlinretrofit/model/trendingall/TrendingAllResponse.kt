package com.ocean.demokotlinretrofit.model.trendingall

import com.google.gson.annotations.SerializedName

data class TrendingAllResponse(
    val page: Int,
    @SerializedName("results") val resultTrendingAll: List<ResultTrendingAll>,
    val total_pages: Int,
    val total_results: Int
)
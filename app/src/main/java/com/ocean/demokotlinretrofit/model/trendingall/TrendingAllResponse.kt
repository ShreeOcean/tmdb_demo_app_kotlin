package com.ocean.demokotlinretrofit.model.trendingall

import com.google.gson.annotations.SerializedName

data class TrendingAllResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val resultTrendingAll: List<ResultTrendingAll>,
    @SerializedName("total_pages") val total_pages: Int,
    @SerializedName("total_results") val total_results: Int
)
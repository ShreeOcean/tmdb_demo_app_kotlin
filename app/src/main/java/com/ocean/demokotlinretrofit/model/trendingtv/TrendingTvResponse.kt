package com.ocean.demokotlinretrofit.model.trendingtv

import com.google.gson.annotations.SerializedName

data class TrendingTvResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val resultTrendingTv: List<ResultTrendingTv>,
    @SerializedName("total_pages") val total_pages: Int,
    @SerializedName("total_results") val total_results: Int
)
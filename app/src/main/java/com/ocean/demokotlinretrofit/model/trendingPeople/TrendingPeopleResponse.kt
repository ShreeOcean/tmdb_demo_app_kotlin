package com.ocean.demokotlinretrofit.model.trendingPeople

import com.google.gson.annotations.SerializedName

data class TrendingPeopleResponse(
    val page: Int,
    @SerializedName("results") val resultTrendingPeople: List<ResultTrendingPeople>,
    val total_pages: Int,
    val total_results: Int
)
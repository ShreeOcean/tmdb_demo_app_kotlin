package com.ocean.demokotlinretrofit.model.trendingPeople

import com.google.gson.annotations.SerializedName

data class TrendingPeopleResponse(
    @SerializedName("page"          ) var page         : Int?               = null,
    @SerializedName("results"       ) var resultsTrendPeople      : ArrayList<ResultTrendPeople> = arrayListOf(),
    @SerializedName("total_pages"   ) var totalPages   : Int?               = null,
    @SerializedName("total_results" ) var totalResults : Int?               = null
)
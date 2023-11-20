package com.ocean.demokotlinretrofit.model.trendingPeople

import com.google.gson.annotations.SerializedName

data class TrendingPeopleResponse(
    var page         : Int,
   @SerializedName("results") var resultsTrendPeople      : ArrayList<ResultTrendPeople> = arrayListOf(),
    var total_pages   : Int,
    var total_results : Int
)
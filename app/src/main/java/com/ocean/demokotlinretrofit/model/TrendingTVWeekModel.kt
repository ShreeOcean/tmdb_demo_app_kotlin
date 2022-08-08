package com.ocean.demokotlinretrofit.model

import com.google.gson.annotations.SerializedName

data class TrendingTVWeekModel(

    @SerializedName("page"          ) var page         : Int?               = null,
    @SerializedName("results"       ) var results      : List<ResultsTrendingTvWeekModel> = arrayListOf(),
    @SerializedName("total_pages"   ) var totalPages   : Int?               = null,
    @SerializedName("total_results" ) var totalResults : Int?               = null
)
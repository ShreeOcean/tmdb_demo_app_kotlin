package com.ocean.demokotlinretrofit.model

import com.google.gson.annotations.SerializedName

data class TrendingResponse(

    @SerializedName("page"          ) var page         : Int?               = null,
    @SerializedName("results"       ) var results      : ArrayList<ResultsDataTrending> = arrayListOf(),
    @SerializedName("total_pages"   ) var totalPages   : Int?               = null,
    @SerializedName("total_results" ) var totalResults : Int?               = null
)
package com.ocean.demokotlinretrofit.model.trendingPeople

import com.google.gson.annotations.SerializedName

data class ResultTrendPeople(
    @SerializedName("adult"                ) var adult              : Boolean?            = null,
    @SerializedName("id"                   ) var id                 : Int?                = null,
    @SerializedName("name"                 ) var name               : String?             = null,
    @SerializedName("original_name"        ) var originalName       : String?             = null,
    @SerializedName("media_type"           ) var mediaType          : String?             = null,
    @SerializedName("popularity"           ) var popularity         : Double?             = null,
    @SerializedName("gender"               ) var gender             : Int?                = null,
    @SerializedName("known_for_department" ) var knownForDepartment : String?             = null,
    @SerializedName("profile_path"         ) var profilePath        : String?             = null,
    @SerializedName("known_for"            ) var knownFor           : ArrayList<KnownFor> = arrayListOf()
)
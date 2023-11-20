package com.ocean.demokotlinretrofit.model.trendingPeople

import com.google.gson.annotations.SerializedName

data class ResultTrendPeople(
    var adult              : Boolean,
    var id                 : Int,
    var name               : String,
    var original_name       : String,
    var media_type          : String,
    var popularity         : Double,
    var gender             : Int,
    var known_for_department : String,
    var profile_path        : String,
    var known_for           : ArrayList<KnownFor> = arrayListOf()
)
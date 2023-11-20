package com.ocean.demokotlinretrofit.model.trendingPeople

import com.google.gson.annotations.SerializedName

data class KnownFor(
    var adult            : Boolean,
    var backdrop_path     : String,
    var id               : Int,
    var title            : String,
    var original_language : String,
    var original_title    : String,
    var overview         : String,
    var poster_path       : String,
    var media_type        : String,
    var genre_ids         : ArrayList<Int> = arrayListOf(),
    var popularity       : Double,
    var release_date      : String,
    var video            : Boolean,
    var vote_average      : Double,
    var vote_count        : Int
)
package com.ocean.demokotlinretrofit.model.trendingall

import com.google.gson.annotations.SerializedName

data class ResultTrendingAll(
    @SerializedName("adult") val adult: Boolean,
    @SerializedName("backdrop_path") val backdrop_path: String,
    @SerializedName("first_air_date")val first_air_date: String,
    @SerializedName("genre_ids") val genre_ids: List<Int>,
    @SerializedName("id")val id: Int,
    @SerializedName("media_type")val media_type: String,
    @SerializedName("name")val name: String,
    @SerializedName("origin_country")val origin_country: List<String>,
    @SerializedName("original_language")val original_language: String,
    @SerializedName("original_name")val original_name: String,
    @SerializedName("original_title")val original_title: String,
    @SerializedName("overview")val overview: String,
    @SerializedName("popularity")val popularity: Double,
    @SerializedName("poster_path")val poster_path: String,
    @SerializedName("release_date")val release_date: String,
    @SerializedName("title")val title: String,
    @SerializedName("video")val video: Boolean,
    @SerializedName("vote_average")val vote_average: Double,
    @SerializedName("vote_count")val vote_count: Int
)
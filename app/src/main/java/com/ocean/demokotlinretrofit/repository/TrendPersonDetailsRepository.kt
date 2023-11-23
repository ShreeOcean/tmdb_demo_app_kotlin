package com.ocean.demokotlinretrofit.repository

import android.util.Log
import com.ocean.demokotlinretrofit.api.APINames
import com.ocean.demokotlinretrofit.utility.AppConstants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class TrendPersonDetailsRepository @Inject constructor(private val apiService: APINames) {

    fun getTrendPersonDetails(i: Int, language: String) = flow {


        emit(apiService.getTrendPersonDetails(i,language))// need person id
    }.catch { e ->

        Log.d("TAG-tpd-repository", "fetchTrendPersonDetails: ${e.message}")
    }.flowOn(Dispatchers.IO)

}
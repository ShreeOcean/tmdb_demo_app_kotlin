package com.ocean.demokotlinretrofit.retrofit

import com.ocean.demokotlinretrofit.utility.AppConstants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal open class RetrofitNetwork() {

    private var httpClient: OkHttpClient.Builder?= null
    private var apiNames: APINames

    companion object{
        val instance: RetrofitNetwork by lazy { RetrofitNetwork() }
    }

    init {
        httpClient = OkHttpClient.Builder()
        apiNames = create(AppConstants.base_url, APINames::class.java)
    }

    fun getApis(): APINames{
        return apiNames
    }

    private fun <T> create(baseUrl : String, clss : Class<T>): T{
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient!!.build())
            .build()
        return retrofit.create(clss)
    }
}
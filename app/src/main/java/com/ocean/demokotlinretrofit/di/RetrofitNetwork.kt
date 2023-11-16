package com.ocean.demokotlinretrofit.di

import com.ocean.demokotlinretrofit.api.APINames
import com.ocean.demokotlinretrofit.utility.AppConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal open class RetrofitNetwork() {

    @Provides
    @Singleton
    fun retrofitProvider(okHttpClient : OkHttpClient) :Retrofit{
        return Retrofit.Builder()
            .baseUrl(AppConstants.base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient() : OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor{ chain ->
                val originalRequest = chain.request()
                val modifiedRequest = originalRequest.newBuilder()
                    .header(AppConstants.AUTHORIZATION_, AppConstants.access_auth_token)
                    .build()
                val response = chain.proceed(modifiedRequest)
                val responseBody = response.body

                response.newBuilder()
                    .body(responseBody)
                    .build()
            }
            .build()
    }

    @Provides
    @Singleton
    fun provideApiSrevice(retrofit : Retrofit) : APINames {
        return retrofit.create(APINames::class.java)
    }

   /* private var httpClient: OkHttpClient.Builder?= null
    private var apiNames: APINames

    companion object{
        val instance: RetrofitNetwork by lazy { RetrofitNetwork() }
    }

    init {
        httpClient = OkHttpClient.Builder()
        apiNames = create(AppConstants.base_url, APINames::class.java)
    }

    fun getApis(): APINames {
        return apiNames
    }

    private fun <T> create(baseUrl : String, clss : Class<T>): T{
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient!!.build())
            .build()
        return retrofit.create(clss)
    }*/
}
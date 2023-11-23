package com.ocean.demokotlinretrofit.utility

sealed class NetworkResult<T>(val data: T?= null, val msg: String?=null) {
    /** will be assign to calling network that process loading stage*/
    class Loading<T> : NetworkResult<T>()

    class Success<T>(data : T?) : NetworkResult<T>(data)

    class Error<T>(msg : String?, data: T? = null) : NetworkResult<T>(data,msg)

    class Empty<T>(msg: String?) : NetworkResult<T>(msg = "Empty")
}
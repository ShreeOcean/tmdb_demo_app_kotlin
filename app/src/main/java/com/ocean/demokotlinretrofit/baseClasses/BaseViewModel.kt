package com.ocean.demokotlinretrofit.baseClasses

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    private val _error : MutableLiveData<String?> = MutableLiveData() //for this class only
    /**public read only live-data where external classes can only observe changes to this and react to error events*/
    val error : LiveData<String?> get() = _error

    fun error(msg : String?){

        if (msg != null){

            /** If msg is not null, it posts the error message to the _error LiveData using postValue.
             * This triggers any observers of the error LiveData to be notified of the error.
             */
            _error.postValue(msg)

            /** It then uses Handler and postDelayed to remove the error message after a delay of 100 milliseconds.
             * This delay is introduced to give UI components time to react to the error message before it gets cleared.
             * Looper.myLooper() retrieves the Looper associated with the current thread.
             * If it is not null, it creates a Handler using this Looper and
             * schedules a delayed action to set the error message to null after 100 milliseconds. */
            Looper.myLooper()?.let {
                Handler(it).postDelayed({_error.postValue(null)}, 100)
            }
        }
    }
}
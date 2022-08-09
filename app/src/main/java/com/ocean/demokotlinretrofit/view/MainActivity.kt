package com.ocean.demokotlinretrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.ocean.demokotlinretrofit.R
import com.ocean.demokotlinretrofit.databinding.ActivityMainBinding
import com.ocean.demokotlinretrofit.retrofit.RetrofitNetwork

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    lateinit var trendingTvWeekViewModel: ViewModel
    private val retrofitNetwork  = RetrofitNetwork.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

}
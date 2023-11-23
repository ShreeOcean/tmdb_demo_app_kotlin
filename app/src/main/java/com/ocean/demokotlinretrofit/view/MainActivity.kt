package com.ocean.demokotlinretrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ocean.demokotlinretrofit.R
import com.ocean.demokotlinretrofit.adapter.MainParentAdapter
import com.ocean.demokotlinretrofit.adapter.TrendingTvWeekRVItemAdapter
import com.ocean.demokotlinretrofit.databinding.ActivityMainBinding
import com.ocean.demokotlinretrofit.viewModel.TrendingDayViewModel
import com.ocean.demokotlinretrofit.viewModel.TrendingTvWeekViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var listener: NavController.OnDestinationChangedListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        binding.lifecycleOwner = this

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listener = NavController.OnDestinationChangedListener { controller, destination, arguments ->
            when(destination.id){

            }
        }

    }

}
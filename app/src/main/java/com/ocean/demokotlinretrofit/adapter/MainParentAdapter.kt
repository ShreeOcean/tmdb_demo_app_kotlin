package com.ocean.demokotlinretrofit.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class MainParentAdapter : RecyclerView.Adapter<MainParentAdapter.MainViewHolder>() {

    val TOTAL_ITEM = 4
    val TrendingAll = 0
    val MovieTrending = 1
    val TvTrending = 2
    val PersonTrending = 3



    open class MainViewHolder(binding : ViewBinding) : RecyclerView.ViewHolder(binding.root) {

        class TrendingViewAdapter(private val trendingBinding : TrendingTvWeekRVItemAdapter){

            fun bind(){

            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainParentAdapter.MainViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MainParentAdapter.MainViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = TOTAL_ITEM
}
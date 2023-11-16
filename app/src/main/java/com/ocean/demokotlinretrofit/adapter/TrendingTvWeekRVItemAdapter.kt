package com.ocean.demokotlinretrofit.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ocean.demokotlinretrofit.R
import com.ocean.demokotlinretrofit.databinding.CustomItemRvResultTrendingBinding
import com.ocean.demokotlinretrofit.model.ResultsDataTrending
import com.ocean.demokotlinretrofit.model.TrendingResponse

class  TrendingTvWeekRVItemAdapter () :
    RecyclerView.Adapter<TrendingTvWeekRVItemAdapter.MyViewHolder>() {

    private var list = mutableListOf<ResultsDataTrending>()

    inner class MyViewHolder(var binding : CustomItemRvResultTrendingBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val  inflater = LayoutInflater.from(parent.context)
        val binding = CustomItemRvResultTrendingBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val listdata = list[position]
        holder.binding.tvNameTrending.text = listdata.name
        holder.binding.tvOverviewTrending.text = "Overview : " + "\n" + listdata.overview
        holder.binding.tvFirstAirDateTrending.text = "First Air Date : " + listdata.firstAirDate

        Glide.with(holder.itemView.context).load(listdata.backdropPath)
            .placeholder(R.drawable.icon_bg_tv).into(holder.binding.imgViewBackdropPath)

        Glide.with(holder.itemView.context).load(listdata.posterPath)
            .placeholder(R.drawable.icon_movie_poster).into(holder.binding.ivPosterTrending)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    /** This fun setListTrendTv is for initializing the mutable list so that we don't need notifyDataSetChanged() for recycler view */
    fun setListTrendTv(list : MutableList<ResultsDataTrending>){
        this.list = list
    }

}


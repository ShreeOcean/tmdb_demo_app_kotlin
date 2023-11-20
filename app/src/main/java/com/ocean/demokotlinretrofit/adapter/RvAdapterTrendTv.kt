package com.ocean.demokotlinretrofit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.ocean.demokotlinretrofit.databinding.AdapterTrendMovieDayBinding
import com.ocean.demokotlinretrofit.databinding.AdapterTrendTvDayBinding
import com.ocean.demokotlinretrofit.model.trendingtv.ResultTrendingTv
import com.ocean.demokotlinretrofit.utility.AppConstants

class RvAdapterTrendTv (private val trendTvData : List<ResultTrendingTv>) : RecyclerView.Adapter<RvAdapterTrendTv.MyViewHolder>(){

    class MyViewHolder(private val binding: AdapterTrendTvDayBinding): ViewHolder(binding.root) {
        fun bind(item : ResultTrendingTv){
            binding.tvTittleTrendTvDay.text = item.original_name
            binding.tvMediaTypeTrendTv.text = "Media Type : ${item.media_type}"
            binding.tvOriginalLanguageTrendTv.text = "Original Language : ${item.original_language}"
            binding.tvReleaseDateTrendTv.text = "First Air Date : ${item.first_air_date}"
            binding.tvVoteAverageTv.text = "Average Vote : ${item.vote_average}"
            binding.tvOverviewTv.text = "Overview : ${item.overview}"

            Glide.with(binding.imgViewPosterPathTrendTv)// context ?
                .load("${AppConstants.image_base_url}${item.poster_path}")
                .into(binding.imgViewPosterPathTrendTv)

            Glide.with(binding.imgViewBackdropPathTrendTv)
                .load("${AppConstants.image_base_url}${item.backdrop_path}")
                .into(binding.imgViewBackdropPathTrendTv)
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val  inflater = LayoutInflater.from(parent.context)
        val binding = AdapterTrendTvDayBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(trendTvData[position])
    }

    override fun getItemCount(): Int = trendTvData.size
}
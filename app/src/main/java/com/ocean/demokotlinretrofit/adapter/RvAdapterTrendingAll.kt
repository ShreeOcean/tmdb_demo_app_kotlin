package com.ocean.demokotlinretrofit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.ocean.demokotlinretrofit.databinding.AdapterTrendingAllDayBinding
import com.ocean.demokotlinretrofit.model.trendingall.ResultTrendingAll
import com.ocean.demokotlinretrofit.utility.AppConstants

class RvAdapterTrendingAll(private var trendingAllData : List<ResultTrendingAll>) : RecyclerView.Adapter<RvAdapterTrendingAll.TrendingAllViewHolder>() {
    class TrendingAllViewHolder(private val binding: AdapterTrendingAllDayBinding): ViewHolder(binding.root) {
        fun bind(item : ResultTrendingAll){
            binding.tvTittleTrendAllDay.text = item.title
            binding.tvMediaTypeTrendAll.text = "Media Type : ${item.media_type}"
            binding.tvOriginalLanguageTrendAll.text = "Original Language : ${item.original_language}"
            binding.tvReleaseDateTrendAll.text = "Release Date : ${item.release_date}"
            binding.tvVoteAverage.text = "Average Vote : ${item.vote_average}"
            binding.tvOverview.text = "Overview : ${item.overview}"

            Glide.with(binding.imgViewPosterPathTrendAll)// context ?
                .load("${AppConstants.image_base_url}${item.poster_path}")

            Glide.with(binding.imgViewBackdropPathTrendAll)
                .load("${AppConstants.image_base_url}${item.backdrop_path}")
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrendingAllViewHolder {
        val  inflater = LayoutInflater.from(parent.context)
        val binding = AdapterTrendingAllDayBinding.inflate(inflater, parent, false)
        return TrendingAllViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrendingAllViewHolder, position: Int) {
        holder.bind(trendingAllData[position])
    }

    override fun getItemCount(): Int = trendingAllData.size
}
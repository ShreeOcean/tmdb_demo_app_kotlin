package com.ocean.demokotlinretrofit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.ocean.demokotlinretrofit.databinding.AdapterTrendMovieDayBinding
import com.ocean.demokotlinretrofit.model.trendingMovie.ResultTrendingMovie
import com.ocean.demokotlinretrofit.utility.AppConstants

class RvAdapterTrendMovie(private var trendingMovie : List<ResultTrendingMovie>) : RecyclerView.Adapter<RvAdapterTrendMovie.TrendMovieViewHolder>() {

    class TrendMovieViewHolder(private val binding : AdapterTrendMovieDayBinding) : ViewHolder(binding.root) {
        fun bind(item : ResultTrendingMovie){
            binding.tvTittleMovie.text = item.title
            binding.tvMediaType.text = "Media Type : ${item.media_type}"
            binding.tvOriginalLanguage.text = "Original Language : ${item.original_language}"
            binding.tvReleaseDateTrendAll.text = "Release Date : ${item.release_date}"
            binding.tvVoteAverage.text = "Average Vote : ${item.vote_average}"
            binding.tvOverview.text = "Overview : ${item.overview}"

            Glide.with(binding.imgViewPosterPathMovie)// context ?
                .load("${AppConstants.image_base_url}${item.poster_path}")
                .into(binding.imgViewPosterPathMovie)

            Glide.with(binding.imgViewBackdropPathMovie)
                .load("${AppConstants.image_base_url}${item.backdrop_path}")
                .into(binding.imgViewBackdropPathMovie)
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrendMovieViewHolder {
        val  inflater = LayoutInflater.from(parent.context)
        val binding = AdapterTrendMovieDayBinding.inflate(inflater, parent, false)
        return TrendMovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrendMovieViewHolder, position: Int) {
        holder.bind(trendingMovie[position])
    }

    override fun getItemCount(): Int = trendingMovie.size
}
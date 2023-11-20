package com.ocean.demokotlinretrofit.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.ocean.demokotlinretrofit.databinding.HorizontalRvLayoutBinding
import com.ocean.demokotlinretrofit.model.trendingMovie.ResultTrendingMovie
import com.ocean.demokotlinretrofit.model.trendingPeople.ResultTrendPeople
import com.ocean.demokotlinretrofit.model.trendingall.ResultTrendingAll
import com.ocean.demokotlinretrofit.model.trendingtv.ResultTrendingTv

class MainParentAdapter : RecyclerView.Adapter<MainParentAdapter.MainViewHolder>() {

    val TOTAL_ITEM = 4
    val TRENDINGALL = 0
    val TRENDINGMOVIE = 1
    val TRENDINGTV = 2
    val TRENDPERSON = 3

    var trendingAllList = listOf<ResultTrendingAll>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var trendTvlist = listOf<ResultTrendingTv>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var trendPersonList = listOf<ResultTrendPeople>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var trendMovieList = listOf<ResultTrendingMovie>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    open class MainViewHolder(private val binding: ViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        class TrendingAllViewHolder(private val trendingAllBinding: HorizontalRvLayoutBinding) :
            MainViewHolder(trendingAllBinding) {
            fun bind(trendingAllList: List<ResultTrendingAll>) {

                trendingAllBinding.txtServiceHeader.text = "Trending All Today:"
                val trendAllAdapter = RvAdapterTrendingAll(trendingAllList)
                trendingAllBinding.rvChildLayout.layoutManager = LinearLayoutManager(
                    trendingAllBinding.root.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                trendAllAdapter.setListTrendAll(trendingAllList)
                trendingAllBinding.rvChildLayout.adapter = trendAllAdapter
            }
        }

        class TrendMovieViewHolder(private val trendMovieBinding : HorizontalRvLayoutBinding) : MainViewHolder(trendMovieBinding){

            fun bind(trendMovieList : List<ResultTrendingMovie>){
                trendMovieBinding.txtServiceHeader.text = "Trending Movie Today:"
                val trendingMovie = RvAdapterTrendMovie(trendMovieList)

                trendMovieBinding.rvChildLayout.layoutManager = LinearLayoutManager(
                    trendMovieBinding.root.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                trendMovieBinding.rvChildLayout.adapter = trendingMovie
            }
        } class TrendPersonViewHolder(private val trendPersonBinding : HorizontalRvLayoutBinding) : MainViewHolder(trendPersonBinding){

            fun bind(trendPersonList : List<ResultTrendPeople>){
                trendPersonBinding.txtServiceHeader.text = "Trending Person Today:"
                val trendingMovie = RvAdapterTrendPerson(trendPersonList)

                trendPersonBinding.rvChildLayout.layoutManager = LinearLayoutManager(
                    trendPersonBinding.root.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                trendPersonBinding.rvChildLayout.adapter = trendingMovie
            }
        } class TrendTvViewHolder(private val trendTvBinding : HorizontalRvLayoutBinding) : MainViewHolder(trendTvBinding){

            fun bind(trendTvList : List<ResultTrendingTv>){
                trendTvBinding.txtServiceHeader.text = "Trending Television Today:"
                val trendingMovie = RvAdapterTrendTv(trendTvList)

                trendTvBinding.rvChildLayout.layoutManager = LinearLayoutManager(
                    trendTvBinding.root.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                trendTvBinding.rvChildLayout.adapter = trendingMovie
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainViewHolder {
        Log.d("ViewType", "onBindViewHolder: $viewType")
        return when (viewType) {

            TRENDINGALL -> MainViewHolder.TrendingAllViewHolder(
                HorizontalRvLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            TRENDINGMOVIE -> MainViewHolder.TrendMovieViewHolder(
                HorizontalRvLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            TRENDINGTV -> MainViewHolder.TrendTvViewHolder( //TODO
                HorizontalRvLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            TRENDPERSON -> MainViewHolder.TrendPersonViewHolder( //TODO
                HorizontalRvLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            else -> throw IllegalArgumentException("Invalid ViewType Provided")
        }
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        when(holder){
            is MainViewHolder.TrendingAllViewHolder -> holder.bind(trendingAllList)
            is MainViewHolder.TrendPersonViewHolder -> holder.bind(trendPersonList)
            is MainViewHolder.TrendTvViewHolder -> holder.bind(trendTvlist)
            is MainViewHolder.TrendMovieViewHolder -> holder.bind(trendMovieList)
        }
    }

    override fun getItemCount(): Int = TOTAL_ITEM

    override fun getItemViewType(position: Int): Int {
        return when(position){
            0 -> TRENDINGALL
            1 -> TRENDINGMOVIE
            2 -> TRENDINGTV
            3 -> TRENDPERSON
            else -> 0
        }
    //super.getItemViewType(position)
    }
}
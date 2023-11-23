package com.ocean.demokotlinretrofit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.ocean.demokotlinretrofit.databinding.AdapterTrendingPersonDayBinding
import com.ocean.demokotlinretrofit.model.trendingPeople.ResultTrendPeople
import com.ocean.demokotlinretrofit.utility.AppConstants
import com.ocean.demokotlinretrofit.view.fragments.home.HomeFragmentDirections

class RvAdapterTrendPerson(private var trendPersonData : List<ResultTrendPeople>) : RecyclerView.Adapter<RvAdapterTrendPerson.MyViewHolder>() {

    class MyViewHolder(private val binding : AdapterTrendingPersonDayBinding) : ViewHolder(binding.root) {
        fun bind(resultTrendPeople: ResultTrendPeople) {
            binding.tvNameTrendPeople.text = resultTrendPeople.name
            binding.tvTrendPeopleKnownFor.text = "Known for : ${resultTrendPeople.known_for_department}"

            Glide.with(binding.imgViewProfileTrendPeople)
                .load("${AppConstants.image_base_url}${resultTrendPeople.profile_path}")
                .into(binding.imgViewProfileTrendPeople)

            binding.imgViewProfileTrendPeople.setOnClickListener {
                redirectFragTrendPersonDetails(resultTrendPeople.id, binding)
            }

        }

        private fun redirectFragTrendPersonDetails(
            trendPersonDetailId: Int,
            binding: AdapterTrendingPersonDayBinding
        ) {
            val actionNav = HomeFragmentDirections.actionHomeFragTrendPeopleDependFrag(trendPersonDetailId)
            binding.root.findNavController().navigate(actionNav)
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val  inflater = LayoutInflater.from(parent.context)
        val binding = AdapterTrendingPersonDayBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(trendPersonData[position])
    }

    override fun getItemCount(): Int = trendPersonData.size

}
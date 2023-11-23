package com.ocean.demokotlinretrofit.view.fragments.trendpeopledetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.ocean.demokotlinretrofit.databinding.FragmentTrendPeopleDetailsBinding
import com.ocean.demokotlinretrofit.utility.NetworkResult
import com.ocean.demokotlinretrofit.model.trendpersondetails.TrendPersonDetailsResponse
import com.ocean.demokotlinretrofit.utility.AppConstants
import com.ocean.demokotlinretrofit.utility.showToast
import com.ocean.demokotlinretrofit.viewModel.TrendPersonDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TrendPeopleDetailsFrag : Fragment() {

    private var bindingFrag: FragmentTrendPeopleDetailsBinding? = null
    private val trendPersonDetailVM by viewModels<TrendPersonDetailsViewModel>()
    private val binding get() = bindingFrag!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingFrag = FragmentTrendPeopleDetailsBinding.inflate(inflater, container, false)
        //code goes here
        trendPersonDetailVM.getTrendPersonDetails(5292, AppConstants.language)//how to get id from

        lifecycleScope.launch {
            trendPersonDetailVM.trendPeopleFlowData.collect{
                when(it){
                    is NetworkResult.Success -> {
                        val trendPersonDetail = it.data
                        updateUI(trendPersonDetail)
                    }
                    is NetworkResult.Error -> {
                        requireContext().showToast("Error : ${it.msg}")
                    }
                    is NetworkResult.Loading -> {
                        binding.progressBarHome.visibility = View.VISIBLE
                    }

                    else -> {
                        requireContext().showToast("Error : Something went wrong please try again later !!!")
                    }
                }
            }
        }

        return binding.root
    }

    private fun updateUI(trendPersonDetail: TrendPersonDetailsResponse?) {

        if (trendPersonDetail != null) {
            binding.progressBarHome.visibility = View.GONE
            binding.tvTrendPersonDetailBirthday.text = "Birthdday : ${trendPersonDetail.birthday}"
            binding.tvTrendPersonDetailDeathday.text = "Deathday : ${trendPersonDetail.deathday}"


        }
    }


}
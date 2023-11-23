package com.ocean.demokotlinretrofit.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ocean.demokotlinretrofit.utility.NetworkResult
import com.ocean.demokotlinretrofit.model.trendpersondetails.TrendPersonDetailsResponse
import com.ocean.demokotlinretrofit.repository.TrendPersonDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrendPersonDetailsViewModel @Inject constructor(
    private val trendPersonRepository: TrendPersonDetailsRepository,
) : ViewModel() {

    private val trendPersonDetailMutable: MutableStateFlow<NetworkResult<TrendPersonDetailsResponse>> =
        MutableStateFlow(NetworkResult.Empty("EmptyData"))
    val trendPeopleFlowData: Flow<NetworkResult<TrendPersonDetailsResponse>> get() = trendPersonDetailMutable

    fun getTrendPersonDetails(i: Int, language: String) = viewModelScope.launch {
        /**  */
        trendPersonDetailMutable.value = NetworkResult.Loading()

        trendPersonRepository.getTrendPersonDetails(i, language).catch {

            trendPersonDetailMutable.value = NetworkResult.Error(it.message)
            it.printStackTrace()
        }
            .collect {
                if (it.isSuccessful) {
                    if (it.body() != null) {
                        trendPersonDetailMutable.value = NetworkResult.Success(it.body())
                    } else {
                        trendPersonDetailMutable.value =
                            NetworkResult.Error(it.message(), it.body())
                    }
                } else {
                    trendPersonDetailMutable.value = NetworkResult.Error(it.message())
                }
            }
    }

}
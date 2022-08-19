package com.example.mvvmhiltsample.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmhiltsample.models.NetworkData
import com.example.mvvmhiltsample.repository.SampleRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SampleViewModel@Inject constructor(private val sampleRepo: SampleRepo):ViewModel() {

    //Get live network data records from room DB as Flow
    val networkData: Flow<List<NetworkData>> = sampleRepo.allData

    /**
     * Launch network request to fetch data using coroutines
     */
    fun performNetworkRequest() = viewModelScope.launch(Dispatchers.IO){
        sampleRepo.performNetworkRequest()
    }
}
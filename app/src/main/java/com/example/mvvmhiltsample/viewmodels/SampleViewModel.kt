package com.example.mvvmhiltsample.viewmodels

import androidx.lifecycle.ViewModel
import com.example.mvvmhiltsample.repository.SampleRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SampleViewModel@Inject constructor(private val sampleRepo: SampleRepo):ViewModel() {

    fun performNetworkRequest(){
        sampleRepo.performNetworkRequest()
    }
}
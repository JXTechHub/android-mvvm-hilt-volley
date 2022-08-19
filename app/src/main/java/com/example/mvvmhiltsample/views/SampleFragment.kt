package com.example.mvvmhiltsample.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import com.example.mvvmhiltsample.R
import com.example.mvvmhiltsample.extensions.showToast
import com.example.mvvmhiltsample.viewmodels.SampleViewModel

/**
 * A simple [Fragment] subclass.
*/
class SampleFragment : Fragment(R.layout.fragment_sample) {

    private val sampleViewModel:SampleViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showToast("FragmentSampleTest")
        sampleViewModel.performNetworkRequest()
    }
}
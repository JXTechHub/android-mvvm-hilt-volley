package com.example.mvvmhiltsample.views

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.mvvmhiltsample.R
import com.example.mvvmhiltsample.databinding.FragmentSampleBinding
import com.example.mvvmhiltsample.extensions.showToast
import com.example.mvvmhiltsample.viewmodels.SampleViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
*/
class SampleFragment : Fragment(R.layout.fragment_sample) {

    private val sampleViewModel:SampleViewModel by activityViewModels()
    private var binding:FragmentSampleBinding? = null

    /**
     * Inflate the layout for this fragment and set [binding]
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSampleBinding.inflate(inflater,container,false)
        return binding!!.root
    }

    /**
     * Set listeners after view is created/inflated
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showToast("FragmentSampleTest")
        sampleViewModel.performNetworkRequest()
        binding?.testGetButton?.setOnClickListener {
            collectData()
        }
    }

    /**
     * Function to collect network data from flow
     */
    private fun collectData(){
        lifecycleScope.launch(Dispatchers.IO) {
            sampleViewModel.networkData.collect{
                Timber.d("it is :%s", it)
            }
        }

    }
}
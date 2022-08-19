package com.example.mvvmhiltsample.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.mvvmhiltsample.R
import com.example.mvvmhiltsample.extensions.showToast

/**
 * A simple [Fragment] subclass.
*/
class SampleFragment : Fragment(R.layout.fragment_sample) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showToast("FragmentSampleTest")
    }
}
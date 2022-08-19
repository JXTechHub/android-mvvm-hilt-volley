package com.example.mvvmhiltsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.mvvmhiltsample.databinding.ActivityMainBinding
import com.example.mvvmhiltsample.extensions.showToast
import com.example.mvvmhiltsample.views.SampleFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showToast("ActivitySampleTest")

        binding.testFetchButton.setOnClickListener {
            changeFragment(SampleFragment())
            Timber.d("Sample Fragment Displayed")
        }
    }

    /**
     * Function to change fragment
     * @param fragment class name
     */
    private fun changeFragment(fragment:Fragment){
        supportFragmentManager.commit {
            add(binding.containerFragment.id,fragment::class.java,null)
        }
    }
}
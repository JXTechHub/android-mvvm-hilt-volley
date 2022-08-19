package com.example.mvvmhiltsample.extensions

import android.app.Activity
import android.widget.Toast
import androidx.fragment.app.Fragment
/**
 * This file is used to shared common functions used across the views without using inheritance.
 * You can add more extension functions if required, these are just some samples.
 */

/**
 * This extension function display a string as a toast msg in fragment
 *@param message user-defined message
 */
fun Fragment.showToast(message:String){
    Toast.makeText(
        requireContext(),
        message,
        Toast.LENGTH_SHORT
    ).show()
}

/**
 * This extension function display a string as a toast msg in activity
 *@param message user-defined message
 */
fun Activity.showToast(message:String){
    Toast.makeText(
        this,
        message,
        Toast.LENGTH_SHORT
    ).show()
}

package com.example.mvvmhiltsample

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import javax.inject.Inject

class NetworkQueue@Inject constructor(appContext: Context) {

    private val requestQueue: RequestQueue by lazy {
        // applicationContext is key, it keeps you from leaking the
        // Activity or BroadcastReceiver if someone passes one in.
        Volley.newRequestQueue(appContext.applicationContext)
    }

    /**
     * Function to add volley request to queue
     * @param req a request that can be any type annotated with T
     */
    fun <T> addToRequestQueue(req: Request<T>) {
        requestQueue.add(req)
    }
}
package com.example.mvvmhiltsample.repository

import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.example.mvvmhiltsample.NetworkQueue
import com.example.mvvmhiltsample.models.NetworkData
import org.json.JSONObject
import timber.log.Timber
import javax.inject.Inject

class SampleRepo @Inject constructor(private val networkQueue: NetworkQueue) {

    companion object{
        private const val WEB_URL = "http://api.open-notify.org/astros.json"
    }

    //To store web data received from the network
    val listOfData = MutableLiveData<List<NetworkData>>()

    /**
     * This function perform a network request using volley to get data from the WEB_URL
     * Get data as Json Object and post data to [listOfData]
     */
     fun performNetworkRequest() {
        val request = StringRequest(
            Request.Method.GET,
            WEB_URL,
            { response ->
                try {
                    //Get data as Json Object
                    val jsonData =JSONObject(response.toString())
                        .getJSONArray("people")
                    Timber.d("Data is :%s",jsonData)

                    val tempList = mutableListOf<NetworkData>()
                    for(each in 0 until jsonData.length()){
                        val filterData = jsonData.getJSONObject(each)
                        tempList.add(NetworkData(filterData.getString("name"),
                        filterData.getString("craft")))
                    }
                    tempList.forEach{
                        Timber.d("It in temp:%s",it)
                    }
                    listOfData.postValue(tempList)

                } catch (e: Exception) {
                    Timber.d("Error in response:%s",e.toString())
                }
            },
            { error ->
                Timber.d("Fail to get response: $error")
            })
        networkQueue.addToRequestQueue(request)
    }
}
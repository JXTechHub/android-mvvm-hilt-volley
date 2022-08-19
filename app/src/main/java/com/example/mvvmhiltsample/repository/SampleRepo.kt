package com.example.mvvmhiltsample.repository

import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.example.mvvmhiltsample.NetworkQueue
import com.example.mvvmhiltsample.interfaces.SampleDao
import com.example.mvvmhiltsample.models.NetworkData
import kotlinx.coroutines.Dispatchers
import org.json.JSONObject
import timber.log.Timber
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SampleRepo @Inject constructor(private val networkQueue: NetworkQueue,
    private val dao: SampleDao) {

    //Stream live data as Flow
    val allData : Flow<List<NetworkData>> = dao.getOrderedNetworkDataFlow()

    companion object{
        private const val WEB_URL = "http://api.open-notify.org/astros.json"
    }

    /**
     * This suspend function perform a network request using volley to get data from the WEB_URL
     * Using a coroutine to fetch network data through the IO Thread
     * Get data as Json Object and insert data to room
     */
    fun performNetworkRequest(){
        val request = StringRequest(
            Request.Method.GET,
            WEB_URL,
            { response ->
                try {
                    //Get data as Json Object
                    val jsonData =JSONObject(response.toString())
                        .getJSONArray("people")
                    Timber.d("Data is :%s",jsonData)

                    for(each in 0 until jsonData.length()){
                        val filterData = jsonData.getJSONObject(each)
                        val tempObj = NetworkData(filterData.getString("name"),
                        filterData.getString("craft"))
                        // Cannot access database on the main thread since it may potentially lock the UI for a long period of time.
                        dao.insert(tempObj)
                    }


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
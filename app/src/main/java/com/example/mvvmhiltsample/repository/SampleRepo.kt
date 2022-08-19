package com.example.mvvmhiltsample.repository

import androidx.lifecycle.MutableLiveData
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

    companion object{
        private const val WEB_URL = "http://api.open-notify.org/astros.json"
    }

    //Stream live data as Flow
    val allData : Flow<List<NetworkData>> = dao.getOrderedNetworkDataFlow()

    //To store webData received from the network
    val webData = MutableLiveData<List<NetworkData>>()

    /**
     * This function insert network data to DB
     */
    fun insertData(data:NetworkData){
        dao.insert(data)
    }

    /**
     * This function deletes data from table
     */
    fun clearAll(){
        dao.clearAll()
    }


    /**
     * This suspend function perform a network request using volley to get data from the WEB_URL
     * Using a coroutine to fetch network data through the IO Thread
     * Get data as Json Object and post to live data
     */
    suspend fun performNetworkRequest() = withContext(Dispatchers.IO){
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
                    webData.postValue(tempList)

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
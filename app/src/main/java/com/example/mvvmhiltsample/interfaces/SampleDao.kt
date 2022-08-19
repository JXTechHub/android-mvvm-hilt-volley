package com.example.mvvmhiltsample.interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import com.example.mvvmhiltsample.models.NetworkData

@Dao
interface SampleDao {

    //Ignore will ignore a new data if it has the same key
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(data:NetworkData)

    // A FlowData stream from the DB to handle live continuous data
    @Query("SELECT * FROM sampleData ORDER BY id ASC")
    fun getOrderedNetworkDataFlow(): Flow<List<NetworkData>>
}
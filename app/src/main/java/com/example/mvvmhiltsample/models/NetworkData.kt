package com.example.mvvmhiltsample.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sample_table")
data class NetworkData(
    val name:String,
    val craft:String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

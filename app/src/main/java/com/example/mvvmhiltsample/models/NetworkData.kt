package com.example.mvvmhiltsample.models

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * Sample data class
 * Ensure each entry is unique
 */
@Entity(tableName = "sample_table", indices = [Index(value = ["id"], unique = true)])
data class NetworkData(
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0,
    val name:String,
    val craft:String
)
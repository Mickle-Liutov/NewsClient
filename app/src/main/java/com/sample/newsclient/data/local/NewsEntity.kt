package com.sample.newsclient.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class NewsEntity(
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "description")
    val description: String?,
    @ColumnInfo(name = "url")
    val url: String,
    @ColumnInfo(name = "imageUrl")
    val imageUrl: String?,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
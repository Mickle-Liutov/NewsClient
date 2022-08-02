package com.sample.newsclient.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NewsDao {

    @Insert
    suspend fun insertAll(news: List<NewsEntity>)

    @Query("SELECT * FROM news")
    suspend fun getAll(): List<NewsEntity>

    @Query("SELECT * FROM news WHERE id=:id")
    suspend fun getById(id: Int): NewsEntity?

}
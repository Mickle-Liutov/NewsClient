package com.sample.newsclient.data

import com.sample.newsclient.api.data.NewsDataSource
import com.sample.newsclient.data.converters.NewsEntityConverter
import com.sample.newsclient.data.converters.NewsResponseConverter
import com.sample.newsclient.data.local.NewsDao
import com.sample.newsclient.data.models.News

class NewsRepository(
    private val newsDataSource: NewsDataSource,
    private val newsDao: NewsDao,
    private val newsResponseConverter: NewsResponseConverter,
    private val newsEntityConverter: NewsEntityConverter
) {

    suspend fun fetchTopNews(): List<News> {
        val newEntities = newsDataSource.fetchTopNews().map {
            newsResponseConverter.toEntity(it)
        }
        newsDao.insertAll(newEntities)
        return newsDao.getAll().map {
            newsEntityConverter.toDomain(it)
        }
    }

    suspend fun fetchNewsById(id: Int): News {
        val foundEntity =
            newsDao.getById(id) ?: throw IllegalStateException("News with id $id was not found.")
        return newsEntityConverter.toDomain(foundEntity)
    }

}
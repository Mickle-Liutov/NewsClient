package com.sample.newsclient.data

import com.sample.newsclient.api.NewsDataSource
import com.sample.newsclient.data.converters.NewsConverter
import com.sample.newsclient.data.models.News

class NewsRepository(
    private val newsDataSource: NewsDataSource,
    private val newsConverter: NewsConverter
) {

    suspend fun fetchTopNews(): List<News> {
        return newsDataSource.fetchTopNews().map {
            newsConverter.fromResponse(it)
        }
    }

}
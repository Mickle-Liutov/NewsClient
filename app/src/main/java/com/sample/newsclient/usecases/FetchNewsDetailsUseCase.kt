package com.sample.newsclient.usecases

import com.sample.newsclient.data.NewsRepository
import com.sample.newsclient.data.models.News

class FetchNewsDetailsUseCase(private val newsRepository: NewsRepository) {

    suspend fun invoke(newsId:Int): News {
        return newsRepository.fetchNewsById(newsId)
    }

}
package com.sample.newsclient.data.converters

import com.sample.newsclient.api.data.NewsResponse
import com.sample.newsclient.data.local.NewsEntity
import com.sample.newsclient.data.models.News

class NewsResponseConverter {

    fun toEntity(newsResponse: NewsResponse): NewsEntity {
        return with(newsResponse) {
            NewsEntity(title, description, url, imageUrl)
        }
    }

}
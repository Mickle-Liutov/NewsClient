package com.sample.newsclient.data.converters

import com.sample.newsclient.api.data.NewsResponse
import com.sample.newsclient.data.local.NewsEntity
import com.sample.newsclient.data.models.News

class NewsEntityConverter {

    fun toDomain(newsEntity: NewsEntity): News {
        return with(newsEntity) {
            News(id, url, title, description, imageUrl)
        }
    }

}
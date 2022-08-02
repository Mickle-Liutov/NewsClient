package com.sample.newsclient.api.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.time.LocalDateTime
import java.time.ZonedDateTime

@JsonClass(generateAdapter = true)
data class NewsListResponse(
    @Json(name = "articles")
    val articles: List<NewsResponse>
)

@JsonClass(generateAdapter = true)
data class NewsResponse(
    @Json(name = "title")
    val title: String,
    @Json(name = "description")
    val description: String?,
    @Json(name = "url")
    val url: String,
    @Json(name = "urlToImage")
    val imageUrl: String?,
    @Json(name = "content")
    val content: String?,
    @Json(name = "publishedAt")
    val publishedAt: ZonedDateTime
)
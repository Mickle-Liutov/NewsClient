package com.sample.newsclient.api.moshi

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.time.LocalDateTime
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

object ZonedDateTimeAdapter {
    private val FORMATTER = DateTimeFormatter.ISO_ZONED_DATE_TIME

    @ToJson
    fun toJsonTime(value: ZonedDateTime): String {
        return FORMATTER.format(value)
    }

    @FromJson
    fun fromJsonTime(value: String): ZonedDateTime {
        return ZonedDateTime.parse(value, FORMATTER)
    }

}
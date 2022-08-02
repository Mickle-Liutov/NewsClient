package com.sample.newsclient.core.networking

import retrofit2.HttpException
import retrofit2.Response

fun <T> Response<T>.toBody(): T {
    val body = body()
    return when {
        !isSuccessful -> throw HttpException(this)
        body != null -> body
        else -> throw NoSuchElementException("No body found in response $this")
    }
}
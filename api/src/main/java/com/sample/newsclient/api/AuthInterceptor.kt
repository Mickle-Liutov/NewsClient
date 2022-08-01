package com.sample.newsclient.api

import okhttp3.Interceptor
import okhttp3.Response

internal class AuthInterceptor(private val apiKey: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
            .addHeader(API_TOKEN_HEADER, apiKey)
            .build()
        return chain.proceed(newRequest)
    }

    companion object {
        private const val API_TOKEN_HEADER = "X-Api-Key"
    }
}
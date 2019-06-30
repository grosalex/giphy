package com.grosalex.giphy.api

import okhttp3.Interceptor

/**
 * @author abruneau
 *         Created on 2019-06-30
 */

class HeaderInterceptor(private val apiKey: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        chain.request().run {
            val requestWithHeader = newBuilder()
                .addHeader("api_key", apiKey)
                .method(method(), body())
                .build()
            return chain.proceed(requestWithHeader)
        }
    }
}
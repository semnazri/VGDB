package com.semnazri.vgdb.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        val originalHttpUrl = original.url
        val httpUrl = originalHttpUrl.newBuilder()
            .build()

        original.newBuilder().url(httpUrl).build()


        return chain.proceed(original)
    }
}
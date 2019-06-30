package com.grosalex.giphy

import android.app.Application
import com.grosalex.giphy.api.GiphyService
import com.grosalex.giphy.api.HeaderInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author abruneau
 *         Created on 2019-06-30
 */
class GiphyApplication : Application() {

    lateinit var service: GiphyService

    override fun onCreate() {
        super.onCreate()
        app = this

        val retrofit = Retrofit.Builder()
            .baseUrl(GiphyService.ROOT)
            .client(createRetrofitClient(GiphyService.API_KEY))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create<GiphyService>(GiphyService::class.java)

    }

    private fun createRetrofitClient(apiKey: String): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HeaderInterceptor(apiKey))
            .build()
    }

    companion object {
        lateinit var app: GiphyApplication

        fun get(): GiphyApplication {
            return app
        }
    }
}
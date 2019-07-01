package com.grosalex.giphy.api

import com.grosalex.giphy.model.BaseGifResponse
import com.grosalex.giphy.model.BaseGifsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author abruneau
 *         Created on 2019-06-30
 */
interface GiphyService {

    @GET("random")
    fun getRandomGif(): Call<BaseGifResponse>

    @GET("search")
    fun searchGif(@Query("q") search:String): Call<BaseGifsResponse>

    companion object {
        const val API_KEY = "useW5sZVPT5jeBQrp9FZUmjDvlycvKaA"
        const val ROOT = "https://api.giphy.com/v1/gifs/"
    }
}
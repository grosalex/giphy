package com.grosalex.giphy.api

import com.grosalex.giphy.model.RandomGifResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * @author abruneau
 *         Created on 2019-06-30
 */
interface GiphyService {

    @GET("random")
    fun getRandomGif(): Call<RandomGifResponse>

    companion object {
        const val API_KEY = "useW5sZVPT5jeBQrp9FZUmjDvlycvKaA"
        const val ROOT = "https://api.giphy.com/v1/gifs/"
    }
}
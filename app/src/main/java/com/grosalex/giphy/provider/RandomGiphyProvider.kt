package com.grosalex.giphy.provider

import com.grosalex.giphy.GiphyApplication
import com.grosalex.giphy.api.ApiCallback
import com.grosalex.giphy.contract.RandomGifContract
import com.grosalex.giphy.model.BaseGifResponse

/**
 * @author abruneau
 *         Created on 2019-06-30
 */

class RandomGiphyProvider : RandomGifContract.Provider {
    override fun getRandomGif(onGifFetched: RandomGifContract.Provider.OnGifFetched) {
        GiphyApplication.get().service.getRandomGif().enqueue(object : ApiCallback<BaseGifResponse>() {
            override fun onSuccess(body: BaseGifResponse?) {
                body?.data?.let { onGifFetched.onSuccess(it) }
            }

            override fun onAnyError(error: String) {
                onGifFetched.onFailure(error)
            }
        })
    }
}
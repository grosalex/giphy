package com.grosalex.giphy.presenter

import com.grosalex.giphy.contract.RandomGifContract
import com.grosalex.giphy.model.Gif

/**
 * @author abruneau
 *         Created on 2019-06-30
 */
class RandomGifPresenter(val view: RandomGifContract.View, val provider: RandomGifContract.Provider) :
    RandomGifContract.Presenter
    , RandomGifContract.Provider.OnGifFetched {
    override fun onSuccess(gif: Gif) {
        view.bind(gif)
    }

    override fun onFailure(message: String) {
        view.onError(message)
    }

    override fun getRandomGif() {
        view.onLoading()
        provider.getRandomGif(this)
    }
}
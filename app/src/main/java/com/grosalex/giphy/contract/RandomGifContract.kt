package com.grosalex.giphy.contract

import com.grosalex.giphy.model.Gif

/**
 * @author abruneau
 *         Created on 2019-06-30
 */
interface RandomGifContract {

    interface View{
        fun bind(gif:Gif)
        fun onError(message:String)
        fun onLoading()
    }

    interface Presenter{
        fun getRandomGif()
    }

    interface Provider{
        interface OnGifFetched{
            fun onSuccess(gif: Gif)
            fun onFailure(message: String)
        }
        fun getRandomGif(onGifFetched: OnGifFetched)
    }
}
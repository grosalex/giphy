package com.grosalex.giphy.contract

import com.grosalex.giphy.model.Gif

/**
 * @author abruneau
 *         Created on 2019-07-01
 */
interface SearchGifContract {

    interface View{
        fun bindSearchResult(gifs:ArrayList<Gif>)
        fun onSearchError(message:String)
        fun onLoadingSearch()
    }

    interface Presenter{
        fun searchGif(search:String)
    }

    interface Provider{
        interface OnSearchFetched{
            fun onSuccess(gifs: ArrayList<Gif>)
            fun onFailure(message: String)
        }

        fun searchGif(search: String, onSearchFetched: OnSearchFetched)
    }
}
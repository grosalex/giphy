package com.grosalex.giphy.presenter

import com.grosalex.giphy.contract.SearchGifContract
import com.grosalex.giphy.model.Gif

/**
 * @author abruneau
 *         Created on 2019-07-01
 */
class SearchPresenter(val view: SearchGifContract.View, val provider: SearchGifContract.Provider) :
    SearchGifContract.Presenter, SearchGifContract.Provider.OnSearchFetched {
    override fun searchGif(search: String) {

        view.onLoadingSearch()
        provider.searchGif(search, this)
    }

    override fun onSuccess(gifs: ArrayList<Gif>) {
        view.bindSearchResult(gifs)
    }

    override fun onFailure(message: String) {
        view.onSearchError(message)
    }
}
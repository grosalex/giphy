package com.grosalex.giphy.provider

import com.grosalex.giphy.GiphyApplication
import com.grosalex.giphy.api.ApiCallback
import com.grosalex.giphy.contract.SearchGifContract
import com.grosalex.giphy.model.BaseGifsResponse
import retrofit2.Call

/**
 * @author abruneau
 *         Created on 2019-07-01
 */
class SearchGifProvider : SearchGifContract.Provider {
    var searchGif: Call<BaseGifsResponse>? = null
    override fun searchGif(search: String, onSearchFetched: SearchGifContract.Provider.OnSearchFetched) {
        searchGif?.cancel()

        searchGif = GiphyApplication.get().service.searchGif(search)
        searchGif?.enqueue(object : ApiCallback<BaseGifsResponse>() {
            override fun onSuccess(body: BaseGifsResponse?) {
                body?.data?.let { onSearchFetched.onSuccess(it) }
            }

            override fun onAnyError(error: String) {
                onSearchFetched.onFailure(error)
            }

        })
    }
}
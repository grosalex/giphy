package com.grosalex.giphy.model

/**
 * @author abruneau
 *         Created on 2019-06-30
 */
data class BaseGifResponse(val data: Gif, val meta: Meta)
data class BaseGifsResponse(val data: ArrayList<Gif>, val meta: Meta)
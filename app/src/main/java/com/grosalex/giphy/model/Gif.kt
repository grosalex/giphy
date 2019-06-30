package com.grosalex.giphy.model

import com.google.gson.annotations.SerializedName

/**
 * @author abruneau
 *         Created on 2019-06-30
 */
data class Gif(
    val type: String?,
    val id: String?,
    val slug: String,
    val url: String?,
    @SerializedName("bitly_url") val bitlyUrl: String?,
    @SerializedName("embed_url") val embedUrl: String?,
    val source: String?,
    val title: String?,
    val images:HashMap<String,Images?>
)

const val DEFAULT_IMAGE = "downsized_medium"
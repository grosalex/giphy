package com.grosalex.giphy.model

import com.google.gson.annotations.SerializedName

/**
 * @author abruneau
 *         Created on 2019-06-30
 */
data class Meta(val msg: String?, val status: Int, @SerializedName("response_id") val responseId: String?)
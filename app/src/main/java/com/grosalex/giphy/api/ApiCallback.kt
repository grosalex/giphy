package com.grosalex.giphy.api

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @author abruneau
 *         Created on 2019-06-30
 */

abstract class ApiCallback<T> : Callback<T> {
    override fun onFailure(call: Call<T>, t: Throwable) {
        Log.e("WsError", t.message)
        t.message?.let { onAnyError(it) }
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        if (response.isSuccessful) {
            onSuccess(response.body())
        } else {
            onAnyError(response.message())
        }
    }

    abstract fun onSuccess(body: T?)
    abstract fun onAnyError(error: String)
}
package com.grosalex.giphy

import android.content.Context
import android.content.Intent
import com.google.gson.Gson
import com.grosalex.giphy.activity.DetailActivity
import com.grosalex.giphy.model.Gif

/**
 * @author abruneau
 *         Created on 2019-07-01
 */
object Navigator {

    fun openDetail(context: Context, gif: Gif){
        val intent= Intent(context, DetailActivity::class.java)
        intent.putExtra(DETAIL_EXTRA, Gson().toJson(gif))
        context.startActivity(intent)
    }

    const val DETAIL_EXTRA = "detail_extra"
}
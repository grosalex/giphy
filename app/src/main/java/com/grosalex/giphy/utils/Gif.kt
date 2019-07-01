package com.grosalex.giphy.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.grosalex.giphy.model.DEFAULT_IMAGE
import com.grosalex.giphy.model.Gif

/**
 * @author abruneau
 *         Created on 2019-07-01
 */

fun Gif.bindIntoImageView(target:ImageView){
    val image = images[DEFAULT_IMAGE] ?: return
    Glide.with(target.context)
        .asGif().load(image.url).centerCrop()
        .into(target)
}
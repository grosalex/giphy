package com.grosalex.giphy.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.grosalex.giphy.R
import com.grosalex.giphy.model.Gif
import com.grosalex.giphy.utils.bindIntoImageView

/**
 * @author abruneau
 *         Created on 2019-07-01
 */
class SearchViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater
        .from(parent.context)
        .inflate(R.layout.search_item, parent, false)
) {
    private val ivGif:ImageView = itemView.findViewById(R.id.iv_gif)

    fun bind(gif: Gif) {
        gif.bindIntoImageView(ivGif)
    }
}
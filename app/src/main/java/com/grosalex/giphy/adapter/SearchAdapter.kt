package com.grosalex.giphy.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.grosalex.giphy.model.Gif
import com.grosalex.giphy.viewholder.SearchViewHolder

/**
 * @author abruneau
 *         Created on 2019-07-01
 */
class SearchAdapter(var gifs:ArrayList<Gif>): RecyclerView.Adapter<SearchViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder = SearchViewHolder(parent)

    override fun getItemCount(): Int = gifs.size

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(gifs[position])
    }
}
package com.grosalex.giphy.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

/**
 * @author abruneau
 *         Created on 2019-06-30
 */

fun AppCompatActivity.configureToolbar(toolbar: Toolbar, title: String? = null) {
    title.let {
        toolbar.title = it
    }
    this.setSupportActionBar(toolbar)
    toolbar.setTitleTextColor(resources.getColor(android.R.color.white))

    toolbar.setNavigationOnClickListener {
        onBackPressed()
    }
}
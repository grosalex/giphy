package com.grosalex.giphy.activity

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.grosalex.giphy.Navigator
import com.grosalex.giphy.R
import com.grosalex.giphy.model.Gif
import com.grosalex.giphy.utils.bindIntoImageView

/**
 * @author abruneau
 *         Created on 2019-07-01
 */
class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detail = intent.getStringExtra(Navigator.DETAIL_EXTRA)
        val gif = Gson().fromJson(detail, Gif::class.java)

        val ivBack: ImageView = findViewById(R.id.iv_back)
        val ivDetail: ImageView = findViewById(R.id.iv_gif_detail)

        gif.bindIntoImageView(ivDetail)
        ivBack.setOnClickListener {
            onBackPressed()
        }
    }
}
package com.grosalex.giphy

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.grosalex.giphy.contract.RandomGifContract
import com.grosalex.giphy.model.DEFAULT_IMAGE
import com.grosalex.giphy.model.Gif
import com.grosalex.giphy.presenter.RandomGifPresenter
import com.grosalex.giphy.provider.RandomGiphyProvider

class MainActivity : AppCompatActivity(), RandomGifContract.View {

    private lateinit var ivGif: ImageView
    private lateinit var loader: ProgressBar
    private lateinit var presenter: RandomGifPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivGif = findViewById(R.id.iv_gif)
        loader = findViewById(R.id.loader)
        presenter = RandomGifPresenter(this, RandomGiphyProvider())
        presenter.getRandomGif()

        ivGif.setOnClickListener {
            presenter.getRandomGif()
        }
    }

    override fun bind(gif: Gif) {
        loader.visibility = View.GONE
        val image = gif.images[DEFAULT_IMAGE] ?: return
        Glide.with(this)
            .asGif().load(image.url).centerCrop()
            .into(ivGif)
    }

    override fun onError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onLoading() {
        loader.visibility = View.VISIBLE
    }

}

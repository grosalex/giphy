package com.grosalex.giphy.activity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.grosalex.giphy.R
import com.grosalex.giphy.adapter.SearchAdapter
import com.grosalex.giphy.contract.RandomGifContract
import com.grosalex.giphy.contract.SearchGifContract
import com.grosalex.giphy.model.Gif
import com.grosalex.giphy.presenter.RandomGifPresenter
import com.grosalex.giphy.presenter.SearchPresenter
import com.grosalex.giphy.provider.RandomGiphyProvider
import com.grosalex.giphy.provider.SearchGifProvider
import com.grosalex.giphy.utils.bindIntoImageView
import com.grosalex.giphy.utils.configureToolbar

class MainActivity : AppCompatActivity(), RandomGifContract.View, SearchGifContract.View {

    private lateinit var ivGif: ImageView
    private lateinit var loader: ProgressBar
    private lateinit var toolbar: Toolbar
    private lateinit var etSearch: EditText
    private lateinit var rvSearch: RecyclerView
    private lateinit var adapter: SearchAdapter
    private lateinit var presenter: RandomGifPresenter
    private lateinit var searchPresenter: SearchPresenter

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            searchPresenter.searchGif(s.toString())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivGif = findViewById(R.id.iv_gif)
        toolbar = findViewById(R.id.toolbar)
        etSearch = findViewById(R.id.et_search)
        etSearch.addTextChangedListener(textWatcher)
        loader = findViewById(R.id.loader)

        searchPresenter = SearchPresenter(this, SearchGifProvider())
        presenter = RandomGifPresenter(this, RandomGiphyProvider())
        presenter.getRandomGif()

        configureToolbar(toolbar)

        ivGif.setOnClickListener {
            presenter.getRandomGif()
        }

        initRecycler()
    }

    private fun initRecycler() {
        rvSearch = findViewById(R.id.rv_gif)
        adapter = SearchAdapter(ArrayList())

        val gridLayoutManager = GridLayoutManager(this, 3)
        rvSearch.layoutManager = gridLayoutManager

        rvSearch.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        return when (item?.itemId) {
            R.id.menu_icon_search -> startSearch()
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun startSearch(): Boolean {
        ivGif.visibility = View.GONE
        toolbar.title = getString(R.string.search_title)
        etSearch.visibility = View.VISIBLE
        etSearch.requestFocus()
        return true
    }

    override fun bind(gif: Gif) {
        loader.visibility = View.GONE
        gif.bindIntoImageView(ivGif)
    }

    override fun onError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onLoading() {
        loader.visibility = View.VISIBLE
    }

    override fun bindSearchResult(gifs: ArrayList<Gif>) {
        loader.visibility = View.GONE
        rvSearch.visibility = View.VISIBLE
        adapter.gifs = gifs
        adapter.notifyDataSetChanged()
    }

    override fun onSearchError(message: String) {
        loader.visibility = View.GONE
    }

    override fun onLoadingSearch() {
        loader.visibility = View.VISIBLE
        adapter.gifs.clear()
        adapter.notifyDataSetChanged()
    }

}

package com.example.retrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.networking.PixabayLoader
import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.Color
import android.graphics.PorterDuff
import android.widget.ImageView


class MainActivity : AppCompatActivity() {

    private val pixabayLoader by lazy {
        PixabayLoader(
            onSuccess = {
                Log.d("Taag", it.toString())
                images_view.layoutManager = LinearLayoutManager(this)

                images_view.adapter = HitsAdapter(
                    hits = it.hits,
                    onItemClick = { image ->

                        val intent = Intent(this, ImageActivity::class.java)
                        intent.putExtra(ImageActivity.EXTRA_ITEM, image.largeImageURL)

                        startActivity(intent)

                    },
                    context = this.applicationContext
                )
            },
            onError = {
                Log.d("Taag", it.message!!)
            }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViews()
    }

    private fun setupViews() {

//        val searchView = findViewById<SearchView>(R.id.search_view);
        //change icon color
//        val searchIcon = search_view.findViewById(androidx.appcompat.R.id.search_mag_icon);
//        val searchIcon:ImageView = search_view.findViewById(androidx.appcompat.R.id.search_mag_icon)
//        searchIcon.drawable.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP)
//            android.graphics.PorterDuff.Mode.SRC_IN);


        pixabayLoader.loadImages()

        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                // task HERE
                pixabayLoader.loadImagesByQuery(search_view.query.toString())
                return false
            }

        })
    }
}

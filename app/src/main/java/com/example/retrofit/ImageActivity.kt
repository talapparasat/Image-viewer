package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_image.*

class ImageActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ITEM = "note"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        val imageURL = intent.getStringExtra(EXTRA_ITEM)

        Picasso.get()
            .load(imageURL)
            .into(image)
    }


}

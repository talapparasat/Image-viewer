package com.example.retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.networking.Hit
import kotlinx.android.synthetic.main.layout_item.view.*
import com.squareup.picasso.Picasso



class HitsAdapter(
    private val hits: List<Hit> = listOf(),
    private val onItemClick: (Hit) -> Unit,
    private val context: Context
) : RecyclerView.Adapter<HitsAdapter.ItemViewHolder>() {
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindItem(hits[position])
    }

    override fun getItemCount() = hits.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_item, parent, false)

        return ItemViewHolder(view)
    }

    inner class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(hit: Hit) {

            Picasso.get()
                .load(hit.webformatURL)
                .into(view.image)

            view.text_tags.text = context.getString(R.string.tags_text, hit.tags)
            view.text_likes.text = context.getString(R.string.likes_text, hit.likes)

            view.setOnClickListener {
                onItemClick(hit)
            }
        }
    }

}
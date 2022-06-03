package com.example.films.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.heroretrofit.model.data.Article
import com.example.newsapi.R
import com.example.newsapi.databinding.CardViewDesignBinding
import com.squareup.picasso.Picasso


class HeroAdapter(
    private val mList: List<Article>?,
) : RecyclerView.Adapter<HeroAdapter.ViewHolder>() {


    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load( mList?.get(position)?.urlToImage)
           .into(holder.imageView)
        holder.binding.nameHero.text = mList?.get(position)?.content

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList!!.size
    }

    // Holds the views for adding it to image and text
    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.PhotoHero)
        val binding = CardViewDesignBinding.bind(itemView)

    }
}
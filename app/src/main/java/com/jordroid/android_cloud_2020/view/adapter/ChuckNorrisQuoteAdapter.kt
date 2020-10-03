package com.jordroid.android_cloud_2020.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jordroid.android_cloud_2020.R
import com.jordroid.android_cloud_2020.model.ChuckNorrisQuote

class ChuckNorrisQuoteAdapter(private val context : Context) : RecyclerView.Adapter<ChuckNorrisQuoteAdapter.StarWardQuoteViewHolder>() {

    /**
     * Attribute
     */

    // Create list of data we want to display in list as var of class
    private val mStarWarsQuote = ArrayList<ChuckNorrisQuote>()
    // Needed to get the item_layout
    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    /**
     * Manage lifecycle
     */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarWardQuoteViewHolder {
        // This line perform the matching with our ViewHolder and the item from layout
        return StarWardQuoteViewHolder(mInflater.inflate(R.layout.item_custom_recycler, parent, false))
    }

    override fun getItemCount(): Int  = mStarWarsQuote.size

    override fun onBindViewHolder(holder: StarWardQuoteViewHolder, position: Int) {
        // onBindViewHolder is called for each item we want to display so we need to get each object
        val currentItem = mStarWarsQuote[position]

        holder.itemRecyclerViewVersionName.text = currentItem.quote
        Glide.with(context)
            .load(currentItem.iconUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.itemRecyclerViewVersionImage)
    }

    /**
     * Public method (Called from activity)
     */

    fun rebuild(chuckNorrisQuote : ArrayList<ChuckNorrisQuote>) {
        // This is the simplest way to update the list
        mStarWarsQuote.clear()
        mStarWarsQuote.addAll(chuckNorrisQuote)
        // Needed to said to recycler view we have new data
        this.notifyDataSetChanged()
    }

    /**
     * Internal class
     */

    inner class StarWardQuoteViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val itemRecyclerViewVersionName: TextView = itemView.findViewById(R.id.itemRecyclerViewVersionName)
        val itemRecyclerViewVersionImage: ImageView = itemView.findViewById(R.id.itemRecyclerViewVersionImage)
    }
}

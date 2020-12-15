package com.godartcn.projetandroidcloud.view.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.godartcn.projetandroidcloud.R
import com.godartcn.projetandroidcloud.interfaces.OnClickCallback
import com.godartcn.projetandroidcloud.model.Avatar

class ImageAdapter(private val context: Context) : RecyclerView.Adapter<ImageAdapter.MyCustomViewHolder>() {
    private val myData : ArrayList<Avatar> = ArrayList()
    private val inflater : LayoutInflater = LayoutInflater.from(context)

    private val callback = context as OnClickCallback

    inner class MyCustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewValue: TextView = itemView.findViewById(R.id.textViewGridLayoutItemRecyclerView)
        val imageViewValue: ImageView = itemView.findViewById(R.id.imageViewGridLayoutItemRecyclerView)

        private fun itemClicked() {
            callback.onItemClick(
                this@ImageAdapter.myData[adapterPosition]
            )
        }

        init {
            this.itemView.setOnClickListener { itemClicked() }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCustomViewHolder {
        return MyCustomViewHolder(inflater.inflate(R.layout.item_custom_recycler, parent, false))
    }

    override fun getItemCount(): Int {
        return myData.size
    }

    override fun onBindViewHolder(holder: MyCustomViewHolder, position: Int) {
        val currentObjectDataSample = myData[position]
        holder.textViewValue.text = currentObjectDataSample.content
        Log.d("URL", currentObjectDataSample.url)
        Glide.with(holder.itemView.context)
            .load(currentObjectDataSample.url)
            .transition(DrawableTransitionOptions.withCrossFade())
            .thumbnail(Glide.with(holder.itemView.context)
                .load(currentObjectDataSample.url+"?blur"))
            .into(holder.imageViewValue)
    }

    fun rebuild(myData: List<Avatar>) {
        this.myData.clear()
        this.myData.addAll(myData)
        this.notifyDataSetChanged()
    }
}
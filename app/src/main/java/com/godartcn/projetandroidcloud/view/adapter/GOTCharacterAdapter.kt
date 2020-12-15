package com.godartcn.projetandroidcloud.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.godartcn.projetandroidcloud.R
import com.godartcn.projetandroidcloud.model.GOTCharacter

class GOTCharacterAdapter(private val context: Context) : RecyclerView.Adapter<GOTCharacterAdapter.MyCustomViewHolder>() {
    private val myData : ArrayList<GOTCharacter> = ArrayList()
    private val inflater : LayoutInflater = LayoutInflater.from(context)

    inner class MyCustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val characterName: TextView = itemView.findViewById(R.id.characterName)
        val characterGender: TextView = itemView.findViewById(R.id.characterGender)
        val characterCulture: TextView = itemView.findViewById(R.id.characterCulture)
        val characterBirthDate: TextView = itemView.findViewById(R.id.characterBirthDate)
        val characterDeathDate: TextView = itemView.findViewById(R.id.characterDeathDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCustomViewHolder {
        return MyCustomViewHolder(inflater.inflate(R.layout.item_character, parent, false))
    }

    override fun getItemCount(): Int {
        return myData.size
    }

    override fun onBindViewHolder(holder: MyCustomViewHolder, position: Int) {
        val currentObjectDataSample = myData[position]
        holder.characterName.text = currentObjectDataSample.name
        holder.characterGender.text = currentObjectDataSample.gender
        holder.characterCulture.text = currentObjectDataSample.culture
        holder.characterBirthDate.text = currentObjectDataSample.born
        holder.characterDeathDate.text = currentObjectDataSample.died
    }

    fun rebuild(myData: List<GOTCharacter>) {
        this.myData.clear()
        this.myData.addAll(myData)
        this.notifyDataSetChanged()
    }
}
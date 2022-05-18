package com.kasiaak.kursakademiaandroida.features.characters.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kasiaak.kursakademiaandroida.R
import com.kasiaak.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable

class CharacterViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.character_single_item, parent, false)) {
    private val characterName: TextView = itemView.findViewById(R.id.character_name)


    fun bind(characterDisplayable: CharacterDisplayable) {
        characterName.text = characterDisplayable.name
    }
}
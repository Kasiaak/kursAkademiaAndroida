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
    /*private val characterStatus: TextView = itemView.findViewById(R.id.character_status)
    private val characterType: TextView = itemView.findViewById(R.id.character_type)
    private val characterGender: TextView = itemView.findViewById(R.id.character_gender)
    private val characterLastKnownLocation: TextView =
        itemView.findViewById(R.id.character_last_known_location)
    private val characterEpisode: TextView = itemView.findViewById(R.id.character_episode)*/

    fun bind(characterDisplayable: CharacterDisplayable) {
        characterName.text = characterDisplayable.name
        /*characterStatus.text = characterDisplayable.status
        characterType.text = characterDisplayable.type
        characterGender.text = characterDisplayable.gender
        characterLastKnownLocation.text = characterDisplayable.lastKnownLocation.name
        characterEpisode.text = characterDisplayable.episode.toString()*/
    }
}
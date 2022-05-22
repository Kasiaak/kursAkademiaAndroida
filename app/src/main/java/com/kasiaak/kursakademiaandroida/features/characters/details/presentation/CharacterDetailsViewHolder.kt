package com.kasiaak.kursakademiaandroida.features.characters.details.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kasiaak.kursakademiaandroida.R
import com.kasiaak.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable

class CharacterDetailsViewHolder(
    inflater: LayoutInflater,
    parent: ViewGroup
) : RecyclerView.ViewHolder(
    inflater.inflate(
        R.layout.character_details_single_item,
        parent,
        false
    )
) {
    private val characterDetailsName: TextView = itemView.findViewById(R.id.character_details_name)
    private val characterDetailsStatus: TextView =
        itemView.findViewById(R.id.character_details_status)
    private val characterDetailsSpecies: TextView =
        itemView.findViewById(R.id.character_details_species)
    private val characterDetailsType: TextView = itemView.findViewById(R.id.character_details_type)
    private val characterDetailsGender: TextView =
        itemView.findViewById(R.id.character_details_gender)
    private val characterDetailsOrigin: TextView =
        itemView.findViewById(R.id.character_details_origin)
    private val characterDetailsLastKnownLocation: TextView =
        itemView.findViewById(R.id.character_details_last_known_location)
    private val characterDetailsEpisodes: TextView =
        itemView.findViewById(R.id.character_details_episodes)

    fun bind(characterDisplayable: CharacterDisplayable) {
        characterDetailsName.text = characterDisplayable.name
        characterDetailsStatus.text = characterDisplayable.status
        characterDetailsSpecies.text = characterDisplayable.species
        characterDetailsType.text = characterDisplayable.type
        characterDetailsGender.text = characterDisplayable.gender
        characterDetailsOrigin.text = characterDisplayable.origin.name
        characterDetailsLastKnownLocation.text = characterDisplayable.lastKnownLocation.name
        characterDetailsEpisodes.text = characterDisplayable.episode.toString()
    }
}
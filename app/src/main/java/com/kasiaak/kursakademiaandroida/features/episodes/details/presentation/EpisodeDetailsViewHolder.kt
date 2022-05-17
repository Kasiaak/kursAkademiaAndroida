package com.kasiaak.kursakademiaandroida.features.episodes.details.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kasiaak.kursakademiaandroida.R
import com.kasiaak.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable

class EpisodeDetailsViewHolder(
    inflater: LayoutInflater,
    parent: ViewGroup
) : RecyclerView.ViewHolder(inflater.inflate(R.layout.episode_details_single_item, parent, false)) {
    private val episodeDetailsName: TextView = itemView.findViewById(R.id.episode_details_name)
    private val episodeDetailsAirDate: TextView =
        itemView.findViewById(R.id.episode_details_air_date)
    private val episodeDetailsCharacters: TextView =
        itemView.findViewById(R.id.episode_details_characters)

    fun bind(episodeDisplayable: EpisodeDisplayable) {
        episodeDetailsName.text = episodeDisplayable.name
        episodeDetailsAirDate.text = episodeDisplayable.airDate
        episodeDetailsCharacters.text = episodeDisplayable.characters.toString()
    }

}
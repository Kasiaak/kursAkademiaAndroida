package com.kasiaak.kursakademiaandroida.features.episodes.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kasiaak.kursakademiaandroida.R
import com.kasiaak.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable

class EpisodeViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.episode_single_item, parent, false)) {

    private val episodeName: TextView = itemView.findViewById(R.id.episode_name)
    /*private val episodeAirDate: TextView = itemView.findViewById(R.id.episode_air_date)
    private val episodeCharacters: TextView = itemView.findViewById(R.id.episode_characters)*/

    fun bind(episodeDisplayable: EpisodeDisplayable) {
        episodeName.text = episodeDisplayable.name
        /*episodeAirDate.text = episodeDisplayable.airDate
        episodeCharacters.text = episodeDisplayable.characters.toString()*/
    }
}

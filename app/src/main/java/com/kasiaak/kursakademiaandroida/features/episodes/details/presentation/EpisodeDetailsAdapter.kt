package com.kasiaak.kursakademiaandroida.features.episodes.details.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.kasiaak.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable

class EpisodeDetailsAdapter
    : ListAdapter<EpisodeDisplayable, EpisodeDetailsViewHolder>(EpisodeDetailsDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeDetailsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return EpisodeDetailsViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: EpisodeDetailsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object EpisodeDetailsDiffCallback : DiffUtil.ItemCallback<EpisodeDisplayable>() {
        override fun areItemsTheSame(
            oldItem: EpisodeDisplayable,
            newItem: EpisodeDisplayable
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: EpisodeDisplayable,
            newItem: EpisodeDisplayable
        ): Boolean {
            return oldItem == newItem
        }
    }
}
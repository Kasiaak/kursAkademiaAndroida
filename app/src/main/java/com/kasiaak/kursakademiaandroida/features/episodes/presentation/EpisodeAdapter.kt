package com.kasiaak.kursakademiaandroida.features.episodes.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.kasiaak.kursakademiaandroida.features.episodes.presentation.model.EpisodeDisplayable

class EpisodeAdapter :
    ListAdapter<EpisodeDisplayable, EpisodeViewHolder>(EpisodeDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return EpisodeViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object EpisodeDiffCallback : DiffUtil.ItemCallback<EpisodeDisplayable>() {
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


package com.kasiaak.kursakademiaandroida.features.episodes.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.kasiaak.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable

class EpisodeAdapter(
    private val onClickListener: OnClickListener
) : ListAdapter<EpisodeDisplayable, EpisodeViewHolder>(EpisodeDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return EpisodeViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val episode = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(episode)
        }
        holder.bind(episode)
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

    class OnClickListener(val clickListener: (episode: EpisodeDisplayable) -> Unit) {
        fun onClick(episode: EpisodeDisplayable) = clickListener(episode)
    }
}

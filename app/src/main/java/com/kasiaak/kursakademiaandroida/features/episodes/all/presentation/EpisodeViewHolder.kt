package com.kasiaak.kursakademiaandroida.features.episodes.all.presentation

import androidx.recyclerview.widget.RecyclerView
import com.kasiaak.kursakademiaandroida.databinding.EpisodeSingleItemBinding
import com.kasiaak.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable

class EpisodeViewHolder(
    private val binding: EpisodeSingleItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    var listener: ((EpisodeDisplayable) -> Unit)? = null
    fun bind(episodeDisplayable: EpisodeDisplayable) {
        with(binding) {
            binding.item = episodeDisplayable
            listener?.let { root.setOnClickListener { it(episodeDisplayable) } }
            binding.executePendingBindings()
        }

    }

}

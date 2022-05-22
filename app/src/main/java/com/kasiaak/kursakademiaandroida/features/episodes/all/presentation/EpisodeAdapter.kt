package com.kasiaak.kursakademiaandroida.features.episodes.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kasiaak.kursakademiaandroida.core.adapter.BindableAdapter
import com.kasiaak.kursakademiaandroida.databinding.EpisodeSingleItemBinding
import com.kasiaak.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable

class EpisodeAdapter
    : BindableAdapter<EpisodeDisplayable>,
    RecyclerView.Adapter<EpisodeViewHolder>() {
    private val episodes = mutableListOf<EpisodeDisplayable>()

    override fun setItems(items: List<EpisodeDisplayable>) {
        if (episodes.isNotEmpty()) this.episodes.clear()

        this.episodes.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = EpisodeSingleItemBinding.inflate(inflater)
        return EpisodeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val episode = episodes[position]
        holder.bind(episode)
    }

    override fun getItemCount(): Int = episodes.size

}

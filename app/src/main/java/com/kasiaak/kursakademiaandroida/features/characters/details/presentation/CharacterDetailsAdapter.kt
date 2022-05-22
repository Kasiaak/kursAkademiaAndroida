package com.kasiaak.kursakademiaandroida.features.characters.details.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.kasiaak.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable

class CharacterDetailsAdapter
    : ListAdapter<CharacterDisplayable, CharacterDetailsViewHolder>(CharacterDetailsDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterDetailsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CharacterDetailsViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: CharacterDetailsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object CharacterDetailsDiffCallback : DiffUtil.ItemCallback<CharacterDisplayable>() {
        override fun areItemsTheSame(
            oldItem: CharacterDisplayable,
            newItem: CharacterDisplayable
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: CharacterDisplayable,
            newItem: CharacterDisplayable
        ): Boolean {
            return oldItem == newItem
        }
    }
}
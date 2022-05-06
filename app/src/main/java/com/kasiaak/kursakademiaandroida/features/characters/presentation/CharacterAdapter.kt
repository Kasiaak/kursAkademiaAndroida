package com.kasiaak.kursakademiaandroida.features.characters.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.kasiaak.kursakademiaandroida.features.characters.presentation.model.CharacterDisplayable

class CharacterAdapter :
    ListAdapter<CharacterDisplayable, CharacterViewHolder>(CharacterDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CharacterViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object CharacterDiffCallback : DiffUtil.ItemCallback<CharacterDisplayable>() {
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
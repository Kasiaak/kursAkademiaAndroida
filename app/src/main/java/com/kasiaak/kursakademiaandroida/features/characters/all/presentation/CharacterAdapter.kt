package com.kasiaak.kursakademiaandroida.features.characters.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.kasiaak.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable

class CharacterAdapter(
    private val onClickListener: OnClickListener
) :
    ListAdapter<CharacterDisplayable, CharacterViewHolder>(CharacterDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CharacterViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(character)
        }
        holder.bind(character)
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

    class OnClickListener(val clickListener: (character: CharacterDisplayable) -> Unit) {
        fun onClick(character: CharacterDisplayable) = clickListener(character)
    }
}
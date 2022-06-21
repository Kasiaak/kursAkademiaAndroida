package com.kasiaak.kursakademiaandroida.features.characters.all.presentation

import androidx.recyclerview.widget.RecyclerView
import com.kasiaak.kursakademiaandroida.databinding.CharacterSingleItemBinding
import com.kasiaak.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable

class CharacterViewHolder(
    private val binding: CharacterSingleItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(characterDisplayable: CharacterDisplayable) {
        with(binding) {
            binding.item = characterDisplayable
            binding.executePendingBindings()
        }
    }
}
package com.kasiaak.kursakademiaandroida.features.characters.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kasiaak.kursakademiaandroida.core.adapter.BindableAdapter
import com.kasiaak.kursakademiaandroida.databinding.CharacterSingleItemBinding
import com.kasiaak.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable

class CharacterAdapter
    : BindableAdapter<CharacterDisplayable>,
    RecyclerView.Adapter<CharacterViewHolder>() {
    private val characters = mutableListOf<CharacterDisplayable>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CharacterSingleItemBinding.inflate(inflater)
        return CharacterViewHolder(binding)
    }


    override fun setItems(items: List<CharacterDisplayable>) {
        if (characters.isNotEmpty()) this.characters.clear()

        this.characters.addAll(items)
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character)
    }


    override fun getItemCount(): Int = characters.size

}
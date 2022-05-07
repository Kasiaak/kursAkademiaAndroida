package com.kasiaak.kursakademiaandroida.features.locations.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.kasiaak.kursakademiaandroida.features.locations.presentation.model.LocationDisplayable

class LocationAdapter :
    ListAdapter<LocationDisplayable, LocationViewHolder>(LocationDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return LocationViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object LocationDiffCallback : DiffUtil.ItemCallback<LocationDisplayable>() {
        override fun areItemsTheSame(
            oldItem: LocationDisplayable,
            newItem: LocationDisplayable
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: LocationDisplayable,
            newItem: LocationDisplayable
        ): Boolean {
            return oldItem == newItem
        }
    }
}
package com.kasiaak.kursakademiaandroida.features.locations.details.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.kasiaak.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable

class LocationDetailsAdapter
    : ListAdapter<LocationDisplayable, LocationDetailsViewHolder>(LocationDetailsDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationDetailsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return LocationDetailsViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: LocationDetailsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object LocationDetailsDiffCallback : DiffUtil.ItemCallback<LocationDisplayable>() {
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
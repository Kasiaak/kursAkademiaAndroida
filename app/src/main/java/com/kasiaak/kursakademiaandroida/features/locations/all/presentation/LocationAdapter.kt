package com.kasiaak.kursakademiaandroida.features.locations.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.kasiaak.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable

class LocationAdapter(
    private val onClickListener: OnClickListener
) :
    ListAdapter<LocationDisplayable, LocationViewHolder>(LocationDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return LocationViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val location = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(location)
        }
        holder.bind(location)
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

    class OnClickListener(val clickListener: (location: LocationDisplayable) -> Unit) {
        fun onClick(location: LocationDisplayable) = clickListener(location)
    }
}
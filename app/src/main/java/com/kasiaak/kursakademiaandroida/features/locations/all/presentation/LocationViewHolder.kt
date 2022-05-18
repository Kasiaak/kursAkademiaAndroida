package com.kasiaak.kursakademiaandroida.features.locations.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kasiaak.kursakademiaandroida.R
import com.kasiaak.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable

class LocationViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.location_single_item, parent, false)) {

    private val locationName: TextView = itemView.findViewById(R.id.location_name)
    /*private val locationType: TextView = itemView.findViewById(R.id.location_type)
    private val locationDimension: TextView = itemView.findViewById(R.id.location_dimension)
    private val locationResidents: TextView = itemView.findViewById(R.id.location_residents)*/

    fun bind(locationDisplayable: LocationDisplayable) {
        locationName.text = locationDisplayable.name
        /*locationType.text = locationDisplayable.type
        locationDimension.text = locationDisplayable.dimension
        locationResidents.text = locationDisplayable.residents.toString()*/
    }
}
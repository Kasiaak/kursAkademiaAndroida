package com.kasiaak.kursakademiaandroida.features.locations.details.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kasiaak.kursakademiaandroida.R
import com.kasiaak.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable

class LocationDetailsViewHolder(
    inflater: LayoutInflater,
    parent: ViewGroup
) : RecyclerView.ViewHolder(
    inflater.inflate(R.layout.location_details_single_item, parent, false)
) {
    private val locationDetailsName: TextView = itemView.findViewById(R.id.location_details_name)
    private val locationDetailsType: TextView = itemView.findViewById(R.id.location_details_type)
    private val locationDetailsDimension: TextView =
        itemView.findViewById(R.id.location_details_dimension)
    private val locationDetailsResidents: TextView =
        itemView.findViewById(R.id.location_details_residents)

    fun bind(locationDisplayable: LocationDisplayable) {
        locationDetailsName.text = locationDisplayable.name
        locationDetailsType.text = locationDisplayable.type
        locationDetailsDimension.text = locationDisplayable.dimension
        locationDetailsResidents.text = locationDisplayable.residents.toString()
    }
}
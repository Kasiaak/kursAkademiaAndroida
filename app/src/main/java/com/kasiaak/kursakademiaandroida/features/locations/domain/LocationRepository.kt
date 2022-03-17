package com.kasiaak.kursakademiaandroida.features.locations.domain

import com.kasiaak.kursakademiaandroida.features.locations.domain.model.Location

interface LocationRepository {
    suspend fun getLocations(): List<Location>
}
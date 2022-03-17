package com.kasiaak.kursakademiaandroida.features.locations.domain

import com.kasiaak.kursakademiaandroida.core.base.UseCase
import com.kasiaak.kursakademiaandroida.features.locations.domain.model.Location

class GetLocationsUseCase(private val locationRepository: LocationRepository) :
    UseCase<List<Location>, Unit>() {
    override suspend fun action(params: Unit): List<Location> = locationRepository.getLocations()
}
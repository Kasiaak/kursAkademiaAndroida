package com.kasiaak.kursakademiaandroida.features.locations.all.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.kasiaak.kursakademiaandroida.core.base.BaseViewModel
import com.kasiaak.kursakademiaandroida.core.exception.ErrorMapper
import com.kasiaak.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable
import com.kasiaak.kursakademiaandroida.features.locations.domain.GetLocationsUseCase
import com.kasiaak.kursakademiaandroida.features.locations.domain.model.Location
import com.kasiaak.kursakademiaandroida.features.locations.navigation.LocationNavigator

class LocationViewModel(
    private val getLocationsUseCase: GetLocationsUseCase,
    private val locationNavigator: LocationNavigator,
    errorMapper: ErrorMapper
) : BaseViewModel(errorMapper) {

    private val _locations by lazy {
        MutableLiveData<List<Location>>()
            .also { getLocations(it) }
    }

    val locations: LiveData<List<LocationDisplayable>> by lazy {
        _locations.map { locations ->
            locations.map {
                LocationDisplayable(it)
            }
        }
    }

    private fun getLocations(locationLiveData: MutableLiveData<List<Location>>) {
        setPendingState()

        getLocationsUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { locationLiveData.value = it }
            result.onFailure { handleFailure(it) }
        }
    }

    fun onLocationClick(location: LocationDisplayable) {
        locationNavigator.openLocationDetailsScreen(location)
    }
}
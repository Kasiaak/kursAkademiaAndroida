package com.kasiaak.kursakademiaandroida.features.locations.details.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kasiaak.kursakademiaandroida.core.base.BaseViewModel
import com.kasiaak.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable

class LocationDetailsViewModel : BaseViewModel() {
    private val _location by lazy { MutableLiveData<LocationDisplayable>() }
    val location: LiveData<LocationDisplayable> by lazy { _location }

    fun passLocation(locationDisplayable: LocationDisplayable) {
        _location.value = locationDisplayable
    }
}
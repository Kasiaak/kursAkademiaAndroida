package com.kasiaak.kursakademiaandroida.features.locations.navigation

import com.kasiaak.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable

interface LocationNavigator {
    fun openLocationDetailsScreen(location: LocationDisplayable)
    fun goBack()
}
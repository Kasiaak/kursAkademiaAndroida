package com.kasiaak.kursakademiaandroida.features.locations.navigation

import com.kasiaak.kursakademiaandroida.R
import com.kasiaak.kursakademiaandroida.core.navigation.FragmentNavigator
import com.kasiaak.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable
import com.kasiaak.kursakademiaandroida.features.locations.details.presentation.LocationDetailsFragment

class LocationNavigatorImpl(private val fragmentNavigator: FragmentNavigator) :
    LocationNavigator {
    override fun openLocationDetailsScreen(location: LocationDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_navigate_from_locations_screen_to_location_details_screen,
            LocationDetailsFragment.LOCATION_DETAILS_KEY to location
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}
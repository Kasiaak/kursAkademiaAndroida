package com.kasiaak.kursakademiaandroida.features.locations.di

import com.kasiaak.kursakademiaandroida.features.locations.all.presentation.LocationFragment
import com.kasiaak.kursakademiaandroida.features.locations.all.presentation.LocationViewModel
import com.kasiaak.kursakademiaandroida.features.locations.data.repository.LocationRepositoryImpl
import com.kasiaak.kursakademiaandroida.features.locations.details.presentation.LocationDetailsFragment
import com.kasiaak.kursakademiaandroida.features.locations.details.presentation.LocationDetailsViewModel
import com.kasiaak.kursakademiaandroida.features.locations.domain.GetLocationsUseCase
import com.kasiaak.kursakademiaandroida.features.locations.domain.LocationRepository
import com.kasiaak.kursakademiaandroida.features.locations.navigation.LocationNavigator
import com.kasiaak.kursakademiaandroida.features.locations.navigation.LocationNavigatorImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val locationModule = module {
    //data
    factory<LocationRepository> { LocationRepositoryImpl(get(), get(), get(), get()) }

    //domain
    factory { GetLocationsUseCase(get()) }

    //presentation
    viewModel { LocationViewModel(get(), get(), get()) }
    factory { LocationFragment() }
    factory<LocationNavigator> { LocationNavigatorImpl(get()) }
    viewModel { LocationDetailsViewModel() }
    factory { LocationDetailsFragment() }
}
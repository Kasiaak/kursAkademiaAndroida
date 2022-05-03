package com.kasiaak.kursakademiaandroida.features.locations.di

import com.kasiaak.kursakademiaandroida.features.locations.data.repository.LocationRepositoryImpl
import com.kasiaak.kursakademiaandroida.features.locations.domain.GetLocationsUseCase
import com.kasiaak.kursakademiaandroida.features.locations.domain.LocationRepository
import com.kasiaak.kursakademiaandroida.features.locations.presentation.LocationFragment
import com.kasiaak.kursakademiaandroida.features.locations.presentation.LocationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val locationModule = module {
    //data
    factory<LocationRepository> { LocationRepositoryImpl(get(), get(), get()) }

    //domain
    factory { GetLocationsUseCase(get()) }

    //presentation
    viewModel { LocationViewModel(get()) }
    factory { LocationFragment() }
}
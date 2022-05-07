package com.kasiaak.kursakademiaandroida.core.di

import com.kasiaak.kursakademiaandroida.features.characters.di.characterModule
import com.kasiaak.kursakademiaandroida.features.episodes.di.episodeModule
import com.kasiaak.kursakademiaandroida.features.locations.di.locationModule
import org.koin.core.module.Module

val featureModules = listOf<Module>(
    episodeModule,
    characterModule,
    locationModule
)
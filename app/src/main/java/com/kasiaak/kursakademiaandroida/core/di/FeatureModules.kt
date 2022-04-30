package com.kasiaak.kursakademiaandroida.core.di

import com.kasiaak.kursakademiaandroida.features.episodes.di.episodeModule
import org.koin.core.module.Module

val featureModules = listOf<Module>(
    episodeModule
)
package com.kasiaak.kursakademiaandroida.core.di

import org.koin.core.module.Module

val koinInjector: List<Module> = featureModules
    .plus(appModule)
    .plus(networkModule)
    .plus(appModule)
    .plus(databaseModule)
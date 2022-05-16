package com.kasiaak.kursakademiaandroida.features.episodes.di

import com.kasiaak.kursakademiaandroida.features.episodes.all.presentation.EpisodeFragment
import com.kasiaak.kursakademiaandroida.features.episodes.all.presentation.EpisodeViewModel
import com.kasiaak.kursakademiaandroida.features.episodes.data.repository.EpisodeRepositoryImpl
import com.kasiaak.kursakademiaandroida.features.episodes.details.presentation.EpisodeDetailsViewModel
import com.kasiaak.kursakademiaandroida.features.episodes.domain.EpisodeRepository
import com.kasiaak.kursakademiaandroida.features.episodes.domain.GetEpisodesUseCase
import com.kasiaak.kursakademiaandroida.features.episodes.navigation.EpisodeNavigator
import com.kasiaak.kursakademiaandroida.features.episodes.navigation.EpisodeNavigatorImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val episodeModule = module {
    //data
    factory<EpisodeRepository> { EpisodeRepositoryImpl(get(), get(), get(), get()) }

    //domain
    factory { GetEpisodesUseCase(get()) }

    //presentation
    viewModel { EpisodeViewModel(get(), get(), get()) }
    factory { EpisodeFragment() }
    factory<EpisodeNavigator> { EpisodeNavigatorImpl(get()) }
    viewModel { EpisodeDetailsViewModel() }
}
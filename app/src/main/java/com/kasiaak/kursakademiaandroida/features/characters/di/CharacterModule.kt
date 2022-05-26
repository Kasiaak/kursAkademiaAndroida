package com.kasiaak.kursakademiaandroida.features.characters.di

import com.kasiaak.kursakademiaandroida.features.characters.all.presentation.CharacterAdapter
import com.kasiaak.kursakademiaandroida.features.characters.all.presentation.CharacterFragment
import com.kasiaak.kursakademiaandroida.features.characters.all.presentation.CharacterViewModel
import com.kasiaak.kursakademiaandroida.features.characters.data.repository.CharacterRepositoryImpl
import com.kasiaak.kursakademiaandroida.features.characters.details.presentation.CharacterDetailsFragment
import com.kasiaak.kursakademiaandroida.features.characters.details.presentation.CharacterDetailsViewModel
import com.kasiaak.kursakademiaandroida.features.characters.domain.CharacterRepository
import com.kasiaak.kursakademiaandroida.features.characters.domain.GetCharactersUseCase
import com.kasiaak.kursakademiaandroida.features.characters.navigation.CharacterNavigator
import com.kasiaak.kursakademiaandroida.features.characters.navigation.CharacterNavigatorImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val characterModule = module {
    //data
    factory<CharacterRepository> { CharacterRepositoryImpl(get(), get(), get(), get()) }

    //domain
    factory { GetCharactersUseCase(get()) }

    //presentation
    viewModel { CharacterViewModel(get(), get(), get()) }
    factory { CharacterFragment() }
    factory { CharacterAdapter() }
    factory<CharacterNavigator> { CharacterNavigatorImpl(get()) }
    viewModel { CharacterDetailsViewModel() }
    factory { CharacterDetailsFragment() }
}
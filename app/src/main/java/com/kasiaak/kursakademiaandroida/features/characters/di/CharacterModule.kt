package com.kasiaak.kursakademiaandroida.features.characters.di

import com.kasiaak.kursakademiaandroida.features.characters.data.repository.CharacterRepositoryImpl
import com.kasiaak.kursakademiaandroida.features.characters.domain.CharacterRepository
import com.kasiaak.kursakademiaandroida.features.characters.domain.GetCharactersUseCase
import com.kasiaak.kursakademiaandroida.features.characters.presentation.CharacterFragment
import com.kasiaak.kursakademiaandroida.features.characters.presentation.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val characterModule = module {
    //data
    factory<CharacterRepository> { CharacterRepositoryImpl(get(), get(), get()) }

    //domain
    factory { GetCharactersUseCase(get()) }

    //presentation
    viewModel { CharacterViewModel(get(), get()) }
    factory { CharacterFragment() }
}
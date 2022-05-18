package com.kasiaak.kursakademiaandroida.features.characters.navigation

import com.kasiaak.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable

interface CharacterNavigator {
    fun openCharacterDetailsScreen(character: CharacterDisplayable)
    fun goBack()
}
package com.kasiaak.kursakademiaandroida.features.characters.navigation

import com.kasiaak.kursakademiaandroida.R
import com.kasiaak.kursakademiaandroida.core.navigation.FragmentNavigator
import com.kasiaak.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable
import com.kasiaak.kursakademiaandroida.features.characters.details.presentation.CharacterDetailsFragment

class CharacterNavigatorImpl(private val fragmentNavigator: FragmentNavigator) :
    CharacterNavigator {
    override fun openCharacterDetailsScreen(character: CharacterDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_navigate_from_characters_screen_to_character_details_screen,
            CharacterDetailsFragment.CHARACTER_DETAILS_KEY to character
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }

}
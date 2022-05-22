package com.kasiaak.kursakademiaandroida.features.characters.details.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kasiaak.kursakademiaandroida.core.base.BaseViewModel
import com.kasiaak.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable

class CharacterDetailsViewModel : BaseViewModel() {

    private val _character by lazy { MutableLiveData<CharacterDisplayable>() }
    val character: LiveData<CharacterDisplayable> by lazy { _character }

    fun passCharacter(characterDisplayable: CharacterDisplayable) {
        _character.value = characterDisplayable
    }
}
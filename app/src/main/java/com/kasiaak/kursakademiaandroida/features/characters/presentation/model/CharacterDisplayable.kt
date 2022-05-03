package com.kasiaak.kursakademiaandroida.features.characters.presentation.model

import com.kasiaak.kursakademiaandroida.features.characters.domain.model.Character
import com.kasiaak.kursakademiaandroida.features.characters.domain.model.CharacterLastKnownLocation
import com.kasiaak.kursakademiaandroida.features.characters.domain.model.CharacterOrigin


data class CharacterDisplayable(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: CharacterOriginDisplayable,
    val lastKnownlocation: CharacterLastKnownLocationDisplayable,
    val image: String,
    val episode: List<String>,
    val url: String
) {
    constructor(character: Character) : this(
        id = character.id,
        name = character.name,
        status = character.status,
        species = character.species,
        type = character.type,
        gender = character.gender,
        origin = CharacterOriginDisplayable(character.origin),
        lastKnownlocation = CharacterLastKnownLocationDisplayable(character.lastKnownLocation),
        image = character.image,
        episode = character.episode,
        url = character.url

    )

    data class CharacterOriginDisplayable(
        val name: String,
        val url: String
    ) {
        constructor(characterOrigin: CharacterOrigin) : this(
            name = characterOrigin.name,
            url = characterOrigin.url
        )
    }

    data class CharacterLastKnownLocationDisplayable(
        val name: String,
        val url: String
    ) {
        constructor(characterLastKnownLocation: CharacterLastKnownLocation) : this(
            name = characterLastKnownLocation.name,
            url = characterLastKnownLocation.url
        )
    }
}
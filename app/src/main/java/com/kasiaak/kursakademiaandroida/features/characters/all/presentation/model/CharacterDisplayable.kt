package com.kasiaak.kursakademiaandroida.features.characters.all.presentation.model

import android.os.Parcelable
import com.kasiaak.kursakademiaandroida.features.characters.domain.model.Character
import com.kasiaak.kursakademiaandroida.features.characters.domain.model.CharacterLastKnownLocation
import com.kasiaak.kursakademiaandroida.features.characters.domain.model.CharacterOrigin
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterDisplayable(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: CharacterOriginDisplayable,
    val lastKnownLocation: CharacterLastKnownLocationDisplayable,
    val image: String,
    val episode: List<String>,
    val url: String
) : Parcelable {
    constructor(character: Character) : this(
        id = character.id,
        name = character.name,
        status = character.status,
        species = character.species,
        type = character.type,
        gender = character.gender,
        origin = CharacterOriginDisplayable(character.origin),
        lastKnownLocation = CharacterLastKnownLocationDisplayable(character.lastKnownLocation),
        image = character.image,
        episode = character.episode,
        url = character.url

    )

    @Parcelize
    data class CharacterOriginDisplayable(
        val name: String,
        val url: String
    ) : Parcelable {
        constructor(characterOrigin: CharacterOrigin) : this(
            name = characterOrigin.name,
            url = characterOrigin.url
        )
    }

    @Parcelize
    data class CharacterLastKnownLocationDisplayable(
        val name: String,
        val url: String
    ) : Parcelable {
        constructor(characterLastKnownLocation: CharacterLastKnownLocation) : this(
            name = characterLastKnownLocation.name,
            url = characterLastKnownLocation.url
        )
    }
}
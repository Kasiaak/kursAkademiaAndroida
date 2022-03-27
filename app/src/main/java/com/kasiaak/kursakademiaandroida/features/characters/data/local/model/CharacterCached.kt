package com.kasiaak.kursakademiaandroida.features.characters.data.local.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kasiaak.kursakademiaandroida.features.characters.domain.model.Character

@Entity(tableName = "character")
data class CharacterCached(
    @PrimaryKey
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    @Embedded
    val origin: CharacterOriginCached,
    @Embedded
    val lastKnownLocation: CharacterLastKnownLocationCached,
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
        origin = CharacterOriginCached(character.origin),
        lastKnownLocation = CharacterLastKnownLocationCached(character.lastKnownLocation),
        image = character.image,
        episode = character.episode,
        url = character.url
    )

    companion object

    fun toCharacter() = Character(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        origin = origin.toCharacterOrigin(),
        lastKnownLocation = lastKnownLocation.toCharacterLastKnownLocation(),
        image = image,
        episode = episode,
        url = url
    )
}

@Entity(tableName = "characterLocationOrigin")
data class CharacterOriginCached(
    val characterOriginName: String,
    val characterOriginUrl: String
) {
    constructor(characterOrigin: Character.CharacterOrigin) : this(
        characterOrigin.name,
        characterOrigin.url
    )

    companion object

    fun toCharacterOrigin() = Character.CharacterOrigin(
        name = characterOriginName,
        url = characterOriginUrl
    )
}

@Entity(tableName = "characterLastKnownLocation")
data class CharacterLastKnownLocationCached(
    val characterLastKnownLocationName: String,
    val characterLastKnownLocationUrl: String
) {
    constructor(characterLastKnownLocationCached: Character.CharacterLastKnownLocation) : this(
        characterLastKnownLocationCached.name,
        characterLastKnownLocationCached.url
    )

    companion object

    fun toCharacterLastKnownLocation() = Character.CharacterLastKnownLocation(
        name = characterLastKnownLocationName,
        url = characterLastKnownLocationUrl
    )
}
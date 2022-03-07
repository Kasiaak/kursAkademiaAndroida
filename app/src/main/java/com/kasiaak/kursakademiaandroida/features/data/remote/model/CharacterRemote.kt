package com.kasiaak.kursakademiaandroida.features.data.remote.model

import com.google.gson.annotations.SerializedName
import com.kasiaak.kursakademiaandroida.features.characters.domain.model.Character


data class CharacterRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String,
    @SerializedName("type") val type: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("origin") val characterOriginRemote: CharacterOriginRemote,
    @SerializedName("location") val characterLastKnownLocationRemote: CharacterLastKnownLocationRemote,
    @SerializedName("image") val image: String,
    @SerializedName("episode") val episode: List<String>,
    @SerializedName("url") val url: String,
    @SerializedName("created") val created: String
) {
    fun toCharacter() = Character(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        origin = characterOriginRemote.toCharacterOrigin(),
        lastKnownLocation = characterLastKnownLocationRemote.toCharacterLastKnownLocation(),
        image = image,
        episode = episode,
        url = url,
        created = created
    )

    data class CharacterOriginRemote(
        @SerializedName("name") val name: String,
        @SerializedName("url") val url: String
    ) {
        fun toCharacterOrigin() = Character.CharacterOrigin(
            name = name,
            url = url
        )
    }

    data class CharacterLastKnownLocationRemote(
        @SerializedName("name") val name: String,
        @SerializedName("url") val url: String
    ) {
        fun toCharacterLastKnownLocation() = Character.CharacterLastKnownLocation(
            name = name,
            url = url
        )
    }
}
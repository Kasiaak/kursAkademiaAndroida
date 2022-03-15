package com.kasiaak.kursakademiaandroida.features.characters.domain

import com.kasiaak.kursakademiaandroida.features.characters.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
}
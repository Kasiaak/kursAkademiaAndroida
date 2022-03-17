package com.kasiaak.kursakademiaandroida.features.characters.domain

import com.kasiaak.kursakademiaandroida.core.base.UseCase
import com.kasiaak.kursakademiaandroida.features.characters.domain.model.Character

class GetCharactersUseCase(private val characterRepository: CharacterRepository) :
    UseCase<List<Character>, Unit>() {
    override suspend fun action(params: Unit): List<Character> = characterRepository.getCharacters()
}
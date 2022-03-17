package com.kasiaak.kursakademiaandroida.features.characters.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test

internal class GetCharactersUseCaseTest {
    @Test
    fun `when use case is invoked then execute getCharacter method from repository`() {
        //given
        val repository = mockk<CharacterRepository>(relaxed = true)
        val useCase = GetCharactersUseCase(repository)

        //when
        useCase(
            params = Unit,
            scope = GlobalScope
        )

        //then
        coVerify { repository.getCharacters() }
    }
}
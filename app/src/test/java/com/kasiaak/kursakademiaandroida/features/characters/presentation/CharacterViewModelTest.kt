package com.kasiaak.kursakademiaandroida.features.characters.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.kasiaak.kursakademiaandroida.core.base.UiState
import com.kasiaak.kursakademiaandroida.core.exception.ErrorMapper
import com.kasiaak.kursakademiaandroida.core.navigation.FragmentNavigator
import com.kasiaak.kursakademiaandroida.features.characters.all.presentation.CharacterViewModel
import com.kasiaak.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable
import com.kasiaak.kursakademiaandroida.features.characters.domain.GetCharactersUseCase
import com.kasiaak.kursakademiaandroida.features.characters.domain.model.Character
import com.kasiaak.kursakademiaandroida.features.characters.navigation.CharacterNavigatorImpl
import com.kasiaak.kursakademiaandroida.mock.mock
import com.kasiaak.kursakademiaandroida.utils.ViewModelTest
import com.kasiaak.kursakademiaandroida.utils.getOrAwaitValue
import com.kasiaak.kursakademiaandroida.utils.observeForTesting
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class CharacterViewModelTest : ViewModelTest() {
    @Test
    fun `WHEN character live data is observed THEN set pending state`() {
        //given
        val useCase = mockk<GetCharactersUseCase>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val characterNavigator = CharacterNavigatorImpl(fragmentNavigator)
        val viewModel = CharacterViewModel(useCase, characterNavigator, errorMapper)

        //when
        viewModel.characters.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Pending
    }

    @Test
    fun `WHEN character live data is observed THEN invoke use case to get characters`() {
        //given
        val useCase = mockk<GetCharactersUseCase>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val characterNavigator = CharacterNavigatorImpl(fragmentNavigator)
        val viewModel = CharacterViewModel(useCase, characterNavigator, errorMapper)

        //when
        viewModel.characters.observeForTesting()

        //then
        verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
    }

    @Test
    fun `GIVEN use case result is success WHEN character live data is observed THEN set idle state AND set result in live data`() {
        //given
        val characters = listOf(Character.mock(), Character.mock(), Character.mock())
        val useCase = mockk<GetCharactersUseCase> {
            every { this@mockk(Unit, any(), any(), any()) } answers {
                lastArg<(Result<List<Character>>) -> Unit>()(Result.success(characters))
            }
        }
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val characterNavigator = CharacterNavigatorImpl(fragmentNavigator)
        val viewModel = CharacterViewModel(useCase, characterNavigator, errorMapper)

        //when
        viewModel.characters.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        viewModel.characters.getOrAwaitValue().forEachIndexed { index, characterDisplayable ->
            val character = characters[index]
            characterDisplayable.id shouldBe character.id
            characterDisplayable.name shouldBe character.name
            characterDisplayable.url shouldBe character.url
        }
    }

    @Test
    fun `GIVEN use case result is failure THEN character live data is observed THEN set idle state AND set error message in live data`() {
        //given
        val throwable = Throwable("Oopsie sth went wrong")
        val useCase = mockk<GetCharactersUseCase> {
            every { this@mockk(Unit, any(), any(), any()) } answers {
                lastArg<(Result<List<Character>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val observer = mockk<Observer<String>>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val characterNavigator = CharacterNavigatorImpl(fragmentNavigator)
        val viewModel = CharacterViewModel(useCase, characterNavigator, errorMapper)

        //when
        viewModel.message.observeForever(observer)
        viewModel.characters.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        verify { observer.onChanged(throwable.message) }
    }

    @Test
    fun `WHEN character is clicked THEN open characterDetailsScreen`() {
        //given
        val useCase: GetCharactersUseCase = mockk(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val characterNavigator = CharacterNavigatorImpl(fragmentNavigator)
        val viewModel = CharacterViewModel(useCase, characterNavigator, errorMapper)
        val characterDisplayable = mockk<CharacterDisplayable>(relaxed = true)

        //when
        viewModel.onCharacterClick(characterDisplayable)

        //then
        verify {
            characterNavigator.openCharacterDetailsScreen(characterDisplayable)
        }
    }
}
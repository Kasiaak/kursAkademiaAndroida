package com.kasiaak.kursakademiaandroida.features.locations.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.kasiaak.kursakademiaandroida.core.base.UiState
import com.kasiaak.kursakademiaandroida.core.exception.ErrorMapper
import com.kasiaak.kursakademiaandroida.core.navigation.FragmentNavigator
import com.kasiaak.kursakademiaandroida.features.locations.all.presentation.LocationViewModel
import com.kasiaak.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable
import com.kasiaak.kursakademiaandroida.features.locations.domain.GetLocationsUseCase
import com.kasiaak.kursakademiaandroida.features.locations.domain.model.Location
import com.kasiaak.kursakademiaandroida.features.locations.navigation.LocationNavigatorImpl
import com.kasiaak.kursakademiaandroida.mock.mock
import com.kasiaak.kursakademiaandroida.utils.ViewModelTest
import com.kasiaak.kursakademiaandroida.utils.getOrAwaitValue
import com.kasiaak.kursakademiaandroida.utils.observeForTesting
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class LocationViewModelTest : ViewModelTest() {
    @Test
    fun `WHEN location live data is observed THEN set pending state`() {
        //given
        val useCase = mockk<GetLocationsUseCase>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val locationNavigator = LocationNavigatorImpl(fragmentNavigator)
        val viewModel = LocationViewModel(useCase, locationNavigator, errorMapper)

        //when
        viewModel.locations.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Pending
    }

    @Test
    fun `WHEN location live data is observed THEN invoke use case to get locations`() {
        //given
        val useCase = mockk<GetLocationsUseCase>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val locationNavigator = LocationNavigatorImpl(fragmentNavigator)
        val viewModel = LocationViewModel(useCase, locationNavigator, errorMapper)

        //when
        viewModel.locations.observeForTesting()

        //then
        verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
    }

    @Test
    fun `GIVEN use case result is success WHEN location live data is observed THEN set idle state AND set result in live data`() {
        //given
        val locations = listOf(Location.mock(), Location.mock(), Location.mock())
        val useCase = mockk<GetLocationsUseCase> {
            every { this@mockk(Unit, any(), any(), any()) } answers {
                lastArg<(Result<List<Location>>) -> Unit>()(Result.success(locations))
            }
        }
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val locationNavigator = LocationNavigatorImpl(fragmentNavigator)
        val viewModel = LocationViewModel(useCase, locationNavigator, errorMapper)

        //when
        viewModel.locations.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        viewModel.locations.getOrAwaitValue().forEachIndexed { index, locationDisplayable ->
            val location = locations[index]
            locationDisplayable.id shouldBe location.id
            locationDisplayable.name shouldBe location.name
            locationDisplayable.url shouldBe location.url
        }

    }

    @Test
    fun `GIVEN use case result is failure THEN location live data is observed THEN set idle state AND set error message in live data`() {
        //given
        val throwable = Throwable("Oopsie sth went wrong")
        val useCase = mockk<GetLocationsUseCase> {
            every { this@mockk(Unit, any(), any(), any()) } answers {
                lastArg<(Result<List<Location>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val observer = mockk<Observer<String>>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val locationNavigator = LocationNavigatorImpl(fragmentNavigator)
        val viewModel = LocationViewModel(useCase, locationNavigator, errorMapper)

        //when
        viewModel.message.observeForever(observer)
        viewModel.locations.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        verify { observer.onChanged(throwable.message) }
    }

    @Test
    fun `WHEN location is clicked THEN open locationDetailsScreen`() {
        //given
        val useCase: GetLocationsUseCase = mockk(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val locationNavigator = LocationNavigatorImpl(fragmentNavigator)
        val viewModel = LocationViewModel(useCase, locationNavigator, errorMapper)
        val locationDisplayable = mockk<LocationDisplayable>(relaxed = true)

        //when
        viewModel.onLocationClick(locationDisplayable)

        //then
        verify {
            locationNavigator.openLocationDetailsScreen(locationDisplayable)
        }
    }
}
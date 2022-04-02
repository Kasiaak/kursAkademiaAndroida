package com.kasiaak.kursakademiaandroida.features.locations.data.repository

import com.kasiaak.kursakademiaandroida.core.api.RickAndMortyApi
import com.kasiaak.kursakademiaandroida.core.api.model.LocationResponse
import com.kasiaak.kursakademiaandroida.core.network.NetworkStateProvider
import com.kasiaak.kursakademiaandroida.features.locations.data.local.LocationDao
import com.kasiaak.kursakademiaandroida.features.locations.data.local.model.LocationCached
import com.kasiaak.kursakademiaandroida.features.locations.domain.LocationRepository
import com.kasiaak.kursakademiaandroida.mock.mock
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

internal class LocationRepositoryImplTest {

    @Test
    fun `GIVEN network is connected WHEN locations request THEN fetch locations from API`() {
        //given
        val api = mockk<RickAndMortyApi> {
            coEvery { getLocations() } returns LocationResponse.mock()
        }
        val locationDao = mockk<LocationDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider>() {
            every { isNetworkAvailable() } returns true
        }
        val repository: LocationRepository =
            LocationRepositoryImpl(api, locationDao, networkStateProvider)

        //when
        runBlocking { repository.getLocations() }

        //then
        coVerify { api.getLocations() }
    }

    @Test
    fun `GIVEN network is connected AND successful data fetch WHEN locations request THEN save locations to local database`() {
        //given
        val api = mockk<RickAndMortyApi> {
            coEvery { getLocations() } returns LocationResponse.mock()
        }
        val locationDao = mockk<LocationDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider>() {
            every { isNetworkAvailable() } returns true
        }
        val repository: LocationRepository =
            LocationRepositoryImpl(api, locationDao, networkStateProvider)

        //when
        runBlocking { repository.getLocations() }

        //then
        coVerify { locationDao.saveLocations(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is disconnected WHEN locations request THEN fetch locations from local database`() {
        //given
        val api = mockk<RickAndMortyApi>(relaxed = true)
        val locationDao = mockk<LocationDao> {
            coEvery { getLocations() } returns listOf(LocationCached.mock(), LocationCached.mock())
        }
        val networkStateProvider = mockk<NetworkStateProvider>() {
            every { isNetworkAvailable() } returns false
        }
        val repository: LocationRepository =
            LocationRepositoryImpl(api, locationDao, networkStateProvider)

        //when
        runBlocking { repository.getLocations() }

        //then
        coVerify { locationDao.getLocations() }
    }
}
package com.kasiaak.kursakademiaandroida.core.api

import com.kasiaak.kursakademiaandroida.core.api.model.CharacterResponse
import com.kasiaak.kursakademiaandroida.core.api.model.EpisodeResponse
import com.kasiaak.kursakademiaandroida.core.api.model.LocationResponse
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("episode")
    suspend fun getEpisodes(): EpisodeResponse

    @GET("location")
    suspend fun getLocations(): LocationResponse

    @GET("character")
    suspend fun getCharacters(): CharacterResponse
}
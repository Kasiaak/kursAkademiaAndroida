package com.kasiaak.kursakademiaandroida.core.api

import com.kasiaak.kursakademiaandroida.core.api.model.EpisodeResponse
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("episodes")
    suspend fun getEpisodes(): EpisodeResponse
}
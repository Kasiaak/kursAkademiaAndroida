package com.kasiaak.kursakademiaandroida.features.episodes

import com.kasiaak.kursakademiaandroida.features.episodes.domain.model.Episode

interface EpisodeRepository {
    suspend fun getEpisodes(): List<Episode>
}
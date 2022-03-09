package com.kasiaak.kursakademiaandroida.features.episodes.domain

import com.kasiaak.kursakademiaandroida.core.base.UseCase
import com.kasiaak.kursakademiaandroida.features.episodes.EpisodeRepository
import com.kasiaak.kursakademiaandroida.features.episodes.domain.model.Episode

class GetEpisodesUseCase(private val episodeRepository: EpisodeRepository) :
    UseCase<List<Episode>, Unit>() {

    override suspend fun action(params: Unit) = episodeRepository.getEpisodes()
}
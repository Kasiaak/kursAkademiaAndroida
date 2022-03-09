package com.kasiaak.kursakademiaandroida.features.episodes.domain

import com.kasiaak.kursakademiaandroida.features.episodes.EpisodeRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test

internal class GetEpisodesUseCaseTest {
    @Test
    fun `when use case is invoked then execute getEpisode method from repository`() {
        //given
        val repository = mockk<EpisodeRepository>(relaxed = true)
        val useCase = GetEpisodesUseCase(repository)

        //when
        useCase(
            params = Unit,
            scope = GlobalScope
        )

        //then
        coVerify { repository.getEpisodes() }
    }
}
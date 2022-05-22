package com.kasiaak.kursakademiaandroida.features.episodes.navigation

import com.kasiaak.kursakademiaandroida.R
import com.kasiaak.kursakademiaandroida.core.navigation.FragmentNavigator
import com.kasiaak.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import com.kasiaak.kursakademiaandroida.mock.mock
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class EpisodeNavigatorImplTest {
    @Test
    fun `WHEN openEpisodeDetailsScreen is called THEN invoke navigateTo method of FragmentNavigator with apropriate action and episode model as arguments`() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val episodeNavigator: EpisodeNavigator = EpisodeNavigatorImpl(fragmentNavigator)
        val episode = EpisodeDisplayable.mock()
        val slot = slot<Pair<String, EpisodeDisplayable>>()
        //when
        episodeNavigator.openEpisodeDetailsScreen(episode)
        //then
        verify {
            fragmentNavigator.navigateTo(
                R.id.action_navigate_from_episodes_screen_to_episode_details_screen,
                capture(slot)
            )
        }
        slot.captured.second shouldBe episode

    }

    @Test
    fun `WHEN goBack is called THEN invoke goBack method of FragmentNavigator`() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val episodeNavigator: EpisodeNavigator = EpisodeNavigatorImpl(fragmentNavigator)

        //when
        episodeNavigator.goBack()
        //then
        verify { fragmentNavigator.goBack() }

    }
}
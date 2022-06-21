package com.kasiaak.kursakademiaandroida.features.episodes.details.presentation

import com.kasiaak.kursakademiaandroida.BR
import com.kasiaak.kursakademiaandroida.R
import com.kasiaak.kursakademiaandroida.core.base.BaseFragment
import com.kasiaak.kursakademiaandroida.databinding.FragmentEpisodeDetailsBinding
import com.kasiaak.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodeDetailsFragment :
    BaseFragment<EpisodeDetailsViewModel, FragmentEpisodeDetailsBinding>(
        BR.episodeDetailsViewModel,
        R.layout.fragment_episode_details
    ) {
    override val viewModel: EpisodeDetailsViewModel by viewModel()

    companion object {
        const val EPISODE_DETAILS_KEY = "episodeDetailsKey"
    }

    override fun initObservers() {
        super.initObservers()
        getDetailsOfClickedEpisode()
    }

    private fun getDetailsOfClickedEpisode() {
        arguments?.getParcelable<EpisodeDisplayable>(EPISODE_DETAILS_KEY)
            ?.let {
                viewModel.passEpisode(it)
            }
    }
}
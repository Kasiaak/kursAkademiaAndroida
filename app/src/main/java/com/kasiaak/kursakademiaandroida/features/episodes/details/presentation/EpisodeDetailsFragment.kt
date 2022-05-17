package com.kasiaak.kursakademiaandroida.features.episodes.details.presentation

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kasiaak.kursakademiaandroida.R
import com.kasiaak.kursakademiaandroida.core.base.BaseFragment
import com.kasiaak.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodeDetailsFragment :
    BaseFragment<EpisodeDetailsViewModel>(R.layout.fragment_episode_details) {
    override val viewModel: EpisodeDetailsViewModel by viewModel()
    private var episodeDetailsAdapter = EpisodeDetailsAdapter()

    companion object {
        const val EPISODE_DETAILS_KEY = "episodeDetailsKey"
    }

    override fun initViews() {
        super.initViews()
        val recyclerView = view?.findViewById<RecyclerView>(R.id.episode_details_recycler_view)
        recyclerView?.apply {
            adapter = episodeDetailsAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun initObservers() {
        super.initObservers()
        getDetailsOfClickedEpisode()
    }

    private fun getDetailsOfClickedEpisode() {
        arguments?.getParcelable<EpisodeDisplayable>(EPISODE_DETAILS_KEY)
            ?.let {
                viewModel.passEpisode(it)
                episodeDetailsAdapter.submitList(listOf(it))
            }

    }

}
package com.kasiaak.kursakademiaandroida.features.episodes.all.presentation

import android.view.View
import android.widget.RelativeLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kasiaak.kursakademiaandroida.R
import com.kasiaak.kursakademiaandroida.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodeFragment : BaseFragment<EpisodeViewModel>(R.layout.fragment_episode) {

    override val viewModel: EpisodeViewModel by viewModel()

    private var episodeAdapter =
        EpisodeAdapter(EpisodeAdapter.OnClickListener { episode -> viewModel.onEpisodeClick(episode) })
    private var progressBar: RelativeLayout? = null

    override fun initViews() {
        super.initViews()
        //initialize all view-related classes
        val recyclerView = view?.findViewById<RecyclerView>(R.id.episode_recycler_view)
        recyclerView?.apply {
            adapter = episodeAdapter
            layoutManager = LinearLayoutManager(context)
        }
        recyclerView?.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                DividerItemDecoration.VERTICAL
            )
        )
        progressBar = view?.findViewById(R.id.episode_progress_bar)
    }

    override fun initObservers() {
        super.initObservers()
        observeEpisodes()
    }

    override fun onIdleState() {
        super.onIdleState()
        progressBar?.visibility = View.GONE
    }

    override fun onPendingState() {
        super.onPendingState()
        progressBar?.visibility = View.VISIBLE
    }

    private fun observeEpisodes() {
        viewModel.episodes.observe(this) {
            //display episodes
            episodeAdapter.submitList(it)
        }
    }

}
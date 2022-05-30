package com.kasiaak.kursakademiaandroida.features.episodes.all.presentation

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kasiaak.kursakademiaandroida.BR
import com.kasiaak.kursakademiaandroida.R
import com.kasiaak.kursakademiaandroida.core.base.BaseFragment
import com.kasiaak.kursakademiaandroida.databinding.FragmentEpisodeBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodeFragment : BaseFragment<EpisodeViewModel, FragmentEpisodeBinding>(
    BR.episodeViewModel,
    R.layout.fragment_episode
) {
    override val viewModel: EpisodeViewModel by viewModel()

    private val episodeAdapter =
        EpisodeAdapter(EpisodeAdapter.OnClickListener { episode -> viewModel.onEpisodeClick(episode) })
    private val divider: DividerItemDecoration by inject()
    private val linearLayoutManager: LinearLayoutManager by inject()


    override fun initViews(binding: FragmentEpisodeBinding) {
        super.initViews(binding)
        initRecycler(binding)
    }

    private fun initRecycler(binding: FragmentEpisodeBinding) {
        with(binding.episodeRecyclerView) {
            adapter = episodeAdapter
            layoutManager = linearLayoutManager
            addItemDecoration(divider)
            setHasFixedSize(true)
        }
    }


    override fun onDestroyView() {
        binding?.episodeRecyclerView?.let {
            it.layoutManager = null
            it.adapter = null
        }
        super.onDestroyView()
    }

}
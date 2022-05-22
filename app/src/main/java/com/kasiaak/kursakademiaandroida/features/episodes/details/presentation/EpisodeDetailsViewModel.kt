package com.kasiaak.kursakademiaandroida.features.episodes.details.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kasiaak.kursakademiaandroida.core.base.BaseViewModel
import com.kasiaak.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable

class EpisodeDetailsViewModel : BaseViewModel() {

    private val _episode by lazy { MutableLiveData<EpisodeDisplayable>() }
    val episode: LiveData<EpisodeDisplayable> by lazy { _episode }

    fun passEpisode(episodeDisplayable: EpisodeDisplayable) {
        _episode.value = episodeDisplayable
    }
}
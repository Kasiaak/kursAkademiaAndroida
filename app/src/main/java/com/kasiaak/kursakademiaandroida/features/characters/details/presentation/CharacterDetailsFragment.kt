package com.kasiaak.kursakademiaandroida.features.characters.details.presentation

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kasiaak.kursakademiaandroida.R
import com.kasiaak.kursakademiaandroida.core.base.BaseFragment
import com.kasiaak.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterDetailsFragment :
    BaseFragment<CharacterDetailsViewModel>(R.layout.fragment_character_details) {
    override val viewModel: CharacterDetailsViewModel by viewModel()
    private var characterDetailsAdapter = CharacterDetailsAdapter()

    companion object {
        const val CHARACTER_DETAILS_KEY = "characterDetailsKey"
    }

    override fun initViews() {
        super.initViews()
        val recyclerView = view?.findViewById<RecyclerView>(R.id.character_details_recycler_view)
        recyclerView?.apply {
            adapter = characterDetailsAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun initObservers() {
        super.initObservers()
        arguments?.getParcelable<CharacterDisplayable>(CHARACTER_DETAILS_KEY)
            ?.let {
                viewModel.passCharacter(it)
                characterDetailsAdapter.submitList(listOf(it))
            }
    }

}
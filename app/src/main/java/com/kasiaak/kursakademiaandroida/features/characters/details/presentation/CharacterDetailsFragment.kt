package com.kasiaak.kursakademiaandroida.features.characters.details.presentation

import androidx.recyclerview.widget.LinearLayoutManager
import com.kasiaak.kursakademiaandroida.BR
import com.kasiaak.kursakademiaandroida.R
import com.kasiaak.kursakademiaandroida.core.base.BaseFragment
import com.kasiaak.kursakademiaandroida.databinding.FragmentCharacterDetailsBinding
import com.kasiaak.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterDetailsFragment :
    BaseFragment<CharacterDetailsViewModel, FragmentCharacterDetailsBinding>(
        BR.characterDetailsViewModel,
        R.layout.fragment_character_details
    ) {
    override val viewModel: CharacterDetailsViewModel by viewModel()
    private var characterDetailsAdapter = CharacterDetailsAdapter()

    companion object {
        const val CHARACTER_DETAILS_KEY = "characterDetailsKey"
    }

    override fun initViews(binding: FragmentCharacterDetailsBinding) {
        super.initViews(binding)
        initRecycler(binding)
    }

    private fun initRecycler(binding: FragmentCharacterDetailsBinding) {
        with(binding.characterDetailsRecyclerView) {
            adapter = characterDetailsAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
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

    override fun onDestroyView() {
        binding?.characterDetailsRecyclerView?.let {
            it.layoutManager = null
            it.adapter = null
        }
        super.onDestroyView()
    }

}
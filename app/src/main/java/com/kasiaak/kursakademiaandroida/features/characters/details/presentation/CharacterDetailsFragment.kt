package com.kasiaak.kursakademiaandroida.features.characters.details.presentation

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

    companion object {
        const val CHARACTER_DETAILS_KEY = "characterDetailsKey"
    }

    override fun initObservers() {
        super.initObservers()
        getDetailsOfClickedCharacter()
    }

    private fun getDetailsOfClickedCharacter() {
        arguments?.getParcelable<CharacterDisplayable>(CHARACTER_DETAILS_KEY)
            ?.let {
                viewModel.passCharacter(it)
            }
    }
}
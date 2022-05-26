package com.kasiaak.kursakademiaandroida.features.characters.all.presentation

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kasiaak.kursakademiaandroida.BR
import com.kasiaak.kursakademiaandroida.R
import com.kasiaak.kursakademiaandroida.core.base.BaseFragment
import com.kasiaak.kursakademiaandroida.databinding.FragmentCharacterBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : BaseFragment<CharacterViewModel, FragmentCharacterBinding>(
    BR.characterViewModel,
    R.layout.fragment_character
) {
    override val viewModel: CharacterViewModel by viewModel()

    private val characterAdapter: CharacterAdapter by inject()
    private val divider: DividerItemDecoration by inject()
    private val linearLayoutManager: LinearLayoutManager by inject()


    override fun initViews(binding: FragmentCharacterBinding) {
        super.initViews(binding)
        initRecycler(binding)
    }

    private fun initRecycler(binding: FragmentCharacterBinding) {
        with(binding.characterRecyclerView) {
            adapter = characterAdapter
            layoutManager = linearLayoutManager
            addItemDecoration(divider)
            setHasFixedSize(true)
        }
    }

    /*override fun initObservers() {
        super.initObservers()
        observeCharacters()
    }*/

    override fun onDestroyView() {
        binding?.characterRecyclerView?.let {
            it.layoutManager = null
            it.adapter = null
        }
        super.onDestroyView()
    }

    /*private fun observeCharacters() {
        viewModel.characters.observe(this) {
            //display characters
            characterAdapter.submitList(it)
        }
    }*/
}
package com.kasiaak.kursakademiaandroida.features.characters.all.presentation

import android.view.View
import android.widget.RelativeLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kasiaak.kursakademiaandroida.R
import com.kasiaak.kursakademiaandroida.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : BaseFragment<CharacterViewModel>(R.layout.fragment_character) {
    override val viewModel: CharacterViewModel by viewModel()

    private var characterAdapter = CharacterAdapter(CharacterAdapter.OnClickListener { character ->
        viewModel.onCharacterClick(character)
    })

    private var progressBar: RelativeLayout? = null

    override fun initViews() {
        super.initViews()
        //initialize all view-related classes
        val recyclerView = view?.findViewById<RecyclerView>(R.id.character_recycler_view)
        recyclerView?.apply {
            adapter = characterAdapter
            layoutManager = LinearLayoutManager(context)
        }
        recyclerView?.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                DividerItemDecoration.VERTICAL
            )
        )
        progressBar = view?.findViewById(R.id.character_progress_bar)
    }

    override fun initObservers() {
        super.initObservers()
        observeCharacters()
    }

    override fun onIdleState() {
        super.onIdleState()
        progressBar?.visibility = View.GONE
    }

    override fun onPendingState() {
        super.onPendingState()
        progressBar?.visibility = View.VISIBLE
    }

    private fun observeCharacters() {
        viewModel.characters.observe(this) {
            //display characters
            characterAdapter.submitList(it)
        }
    }
}
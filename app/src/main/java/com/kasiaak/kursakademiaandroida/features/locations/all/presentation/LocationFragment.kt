package com.kasiaak.kursakademiaandroida.features.locations.all.presentation

import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kasiaak.kursakademiaandroida.BR
import com.kasiaak.kursakademiaandroida.R
import com.kasiaak.kursakademiaandroida.core.base.BaseFragment
import com.kasiaak.kursakademiaandroida.databinding.FragmentLocationBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationFragment : BaseFragment<LocationViewModel, FragmentLocationBinding>(
    BR.locationViewModel,
    R.layout.fragment_location
) {

    override val viewModel: LocationViewModel by viewModel()

    private var locationAdapter = LocationAdapter(LocationAdapter.OnClickListener { location ->
        viewModel.onLocationClick(location)
    })

    private val divider: DividerItemDecoration by inject()

    override fun initViews(binding: FragmentLocationBinding) {
        super.initViews(binding)
        initRecycler(binding)
    }

    private fun initRecycler(binding: FragmentLocationBinding) {
        with(binding.locationRecyclerView) {
            adapter = locationAdapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(divider)
            setHasFixedSize(true)
        }
    }

    override fun initObservers() {
        super.initObservers()
        observeLocations()
    }

    override fun onIdleState() {
        super.onIdleState()
        binding?.let { it.locationProgressBar.visibility = View.GONE }
    }

    override fun onPendingState() {
        super.onPendingState()
        binding?.let { it.locationProgressBar.visibility = View.VISIBLE }
    }

    override fun onDestroyView() {
        binding?.locationRecyclerView?.let {
            it.layoutManager = null
            it.adapter = null
        }
        super.onDestroyView()
    }

    private fun observeLocations() {
        viewModel.locations.observe(this) {
            //display locations
            locationAdapter.submitList(it)
        }
    }
}
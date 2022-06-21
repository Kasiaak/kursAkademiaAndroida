package com.kasiaak.kursakademiaandroida.features.locations.details.presentation

import androidx.recyclerview.widget.LinearLayoutManager
import com.kasiaak.kursakademiaandroida.BR
import com.kasiaak.kursakademiaandroida.R
import com.kasiaak.kursakademiaandroida.core.base.BaseFragment
import com.kasiaak.kursakademiaandroida.databinding.FragmentLocationDetailsBinding
import com.kasiaak.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable
import org.koin.androidx.viewmodel.ext.android.viewModel


class LocationDetailsFragment :
    BaseFragment<LocationDetailsViewModel, FragmentLocationDetailsBinding>(
        BR.locationDetailsViewModel,
        R.layout.fragment_location_details
    ) {
    override val viewModel: LocationDetailsViewModel by viewModel()
    private var locationDetailsAdapter = LocationDetailsAdapter()

    companion object {
        const val LOCATION_DETAILS_KEY = "locationDetailsKey"
    }

    override fun initViews(binding: FragmentLocationDetailsBinding) {
        super.initViews(binding)
        initRecycler(binding)
    }

    private fun initRecycler(binding: FragmentLocationDetailsBinding) {
        with(binding.locationDetailsRecyclerView) {
            adapter = locationDetailsAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }

    override fun initObservers() {
        super.initObservers()
        arguments?.getParcelable<LocationDisplayable>(LOCATION_DETAILS_KEY)
            ?.let {
                viewModel.passLocation(it)
                locationDetailsAdapter.submitList(listOf(it))
            }
    }

    override fun onDestroyView() {
        binding?.locationDetailsRecyclerView?.let {
            it.layoutManager = null
            it.adapter = null
        }
        super.onDestroyView()
    }

}
package com.kasiaak.kursakademiaandroida.features.locations.details.presentation

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kasiaak.kursakademiaandroida.R
import com.kasiaak.kursakademiaandroida.core.base.BaseFragment
import com.kasiaak.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable
import org.koin.androidx.viewmodel.ext.android.viewModel


class LocationDetailsFragment :
    BaseFragment<LocationDetailsViewModel>(R.layout.fragment_location_details) {
    override val viewModel: LocationDetailsViewModel by viewModel()
    private var locationDetailsAdapter = LocationDetailsAdapter()

    companion object {
        const val LOCATION_DETAILS_KEY = "locationDetailsKey"
    }

    override fun initViews() {
        super.initViews()
        val recyclerView = view?.findViewById<RecyclerView>(R.id.location_details_recycler_view)
        recyclerView?.apply {
            adapter = locationDetailsAdapter
            layoutManager = LinearLayoutManager(context)
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

}
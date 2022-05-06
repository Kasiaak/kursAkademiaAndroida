package com.kasiaak.kursakademiaandroida.features.locations.presentation

import android.view.View
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kasiaak.kursakademiaandroida.R
import com.kasiaak.kursakademiaandroida.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationFragment : BaseFragment<LocationViewModel>(R.layout.fragment_location) {

    override val viewModel: LocationViewModel by viewModel()

    private var locationAdapter = LocationAdapter()
    private var progressBar: RelativeLayout? = null

    override fun initViews() {
        super.initViews()
        //initialize all view-related classes
        val recyclerView = view?.findViewById<RecyclerView>(R.id.location_recycler_view)
        recyclerView?.apply {
            adapter = locationAdapter
            layoutManager = LinearLayoutManager(context)
        }
        progressBar = view?.findViewById(R.id.location_progress_bar)
    }

    override fun initObservers() {
        super.initObservers()
        observeLocations()
    }

    override fun onIdleState() {
        super.onIdleState()
        progressBar?.visibility = View.GONE
    }

    override fun onPendingState() {
        super.onPendingState()
        progressBar?.visibility = View.VISIBLE
    }

    private fun observeLocations() {
        viewModel.locations.observe(this) {
            //display locations
            locationAdapter.submitList(ArrayList(it))
        }
    }
}
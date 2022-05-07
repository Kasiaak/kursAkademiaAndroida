package com.kasiaak.kursakademiaandroida.core.base

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

abstract class BaseFragment<T : BaseViewModel>(@LayoutRes layoutRes: Int) : Fragment(layoutRes) {

    abstract val viewModel: T

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
        bindViewModelToLifecycle()
    }

    private fun bindViewModelToLifecycle() {
        lifecycle.addObserver(viewModel)
    }

    open fun initViews() {

    }

    open fun initObservers() {
        observeMessage()
        observeUiState()
    }

    private fun observeMessage() {
        viewModel.message.observe(viewLifecycleOwner) {
            showToast(it)
        }
    }

    protected fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    protected fun showToast(@StringRes stringRes: Int) {
        showToast(getString(stringRes))
    }

    private fun observeUiState() {
        viewModel.uiState.observe(viewLifecycleOwner) {
            when (it) {
                UiState.Idle -> onIdleState()
                UiState.Pending -> onPendingState()

            }
        }
    }

    open fun onIdleState() {
        //handle idle state
    }

    open fun onPendingState() {
        //handle pending state
    }
}

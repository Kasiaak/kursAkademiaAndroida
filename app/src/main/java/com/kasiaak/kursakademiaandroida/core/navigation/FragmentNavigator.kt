package com.kasiaak.kursakademiaandroida.core.navigation

import androidx.annotation.IdRes

interface FragmentNavigator {
    fun navigateTo(
        @IdRes destinationIdRes: Int,
        fragmentTransition: FragmentTransition? = null
    )

    fun <T> navigateTo(
        @IdRes destinationIdRes: Int,
        param: Pair<String, T>? = null,
        fragmentTransition: FragmentTransition? = null
    )

    fun goBack(@IdRes destinationIdRes: Int? = null, inclusive: Boolean = false)
    fun cleanHistory()
}
package com.kasiaak.kursakademiaandroida.core.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.navigation.navOptions
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kasiaak.kursakademiaandroida.R
import com.kasiaak.kursakademiaandroida.core.exception.ErrorMapper
import com.kasiaak.kursakademiaandroida.core.exception.ErrorMapperImpl
import com.kasiaak.kursakademiaandroida.core.exception.ErrorWrapper
import com.kasiaak.kursakademiaandroida.core.exception.ErrorWrapperImpl
import com.kasiaak.kursakademiaandroida.core.navigation.FragmentNavigator
import com.kasiaak.kursakademiaandroida.core.navigation.FragmentNavigatorImpl
import com.kasiaak.kursakademiaandroida.core.network.NetworkStateProvider
import com.kasiaak.kursakademiaandroida.core.network.NetworkStateProviderImpl
import com.kasiaak.kursakademiaandroida.core.provider.ActivityProvider
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

const val SPAN_COUNT = 2

val appModule = module {
    factory { LinearLayoutManager(androidContext()) }
    factory { GridLayoutManager(androidContext(), SPAN_COUNT) }
    factory { DividerItemDecoration(androidContext(), LinearLayoutManager.VERTICAL) }
    factory { androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }
    factory<NetworkStateProvider> { NetworkStateProviderImpl(get()) }
    factory<ErrorWrapper> { ErrorWrapperImpl() }
    factory<ErrorMapper> { ErrorMapperImpl(androidContext()) }

    single(createdAtStart = true) { ActivityProvider(androidApplication()) }
    factory<FragmentNavigator> {
        FragmentNavigatorImpl(
            activityProvider = get(),
            navHostFragmentRes = R.id.nav_host_fragment_activity_main2,
            homeDestinationRes = R.id.episodes_screen,
            defaultNavOptions = get()
        )
    }

    factory {
        navOptions {
            anim { enter = androidx.navigation.ui.R.anim.nav_default_enter_anim }
            anim { exit = androidx.navigation.ui.R.anim.nav_default_exit_anim }
            anim { popEnter = androidx.navigation.ui.R.anim.nav_default_pop_enter_anim }
            anim { popExit = androidx.navigation.ui.R.anim.nav_default_pop_exit_anim }
        }
    }
}
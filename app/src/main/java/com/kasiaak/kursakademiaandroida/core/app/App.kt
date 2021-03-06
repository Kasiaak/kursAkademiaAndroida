package com.kasiaak.kursakademiaandroida.core.app

import android.app.Application
import com.kasiaak.kursakademiaandroida.core.di.koinInjector
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin()
    }

    private fun startKoin() {
        startKoin {
            androidContext(this@App)
            modules(koinInjector)
        }
    }
}
package com.kasiaak.kursakademiaandroida.core.network

interface NetworkStateProvider {
    fun isNetworkAvailable(): Boolean
}
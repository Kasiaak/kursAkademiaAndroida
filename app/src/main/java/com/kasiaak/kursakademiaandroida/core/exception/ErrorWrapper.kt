package com.kasiaak.kursakademiaandroida.core.exception

interface ErrorWrapper {
    fun wrap(throwable: Throwable): Throwable
}
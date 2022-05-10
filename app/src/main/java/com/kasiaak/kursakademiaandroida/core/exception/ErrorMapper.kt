package com.kasiaak.kursakademiaandroida.core.exception

interface ErrorMapper {
    fun map(throwable: Throwable): String
}
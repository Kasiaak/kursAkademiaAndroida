package com.kasiaak.kursakademiaandroida.core.di

import androidx.room.Room
import com.kasiaak.kursakademiaandroida.core.data.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "room-db")
            .build()
    }

    single { get<AppDatabase>().episodeDao() }
}
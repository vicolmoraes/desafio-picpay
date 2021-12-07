package com.picpay.desafio.android.koinModules

import androidx.room.Room
import com.picpay.desafio.android.data.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val daoSingleModule = module {
    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, "database")
            .fallbackToDestructiveMigration()
            .build()
    }
}
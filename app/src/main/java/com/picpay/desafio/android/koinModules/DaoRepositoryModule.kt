package com.picpay.desafio.android.koinModules

import androidx.room.Room
import com.picpay.desafio.android.data.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val daoRepositoryModule = module {
    factory { get<AppDatabase>().userDao() }
}
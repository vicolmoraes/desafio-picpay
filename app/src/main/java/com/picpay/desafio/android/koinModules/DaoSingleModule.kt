package com.picpay.desafio.android.koinModules

import com.picpay.desafio.android.data.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val daoSingleModule = module {
    single {
        AppDatabase.getDatabase(androidApplication()).userDao()
    }
}
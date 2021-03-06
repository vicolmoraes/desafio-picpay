package com.picpay.desafio.android

import android.app.Application
import co.idwall.iddog.data.*
import com.picpay.desafio.android.koinModules.daoSingleModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules(listOf(userRepositoryModule, userViewModelModule, daoSingleModule))
        }
    }
}
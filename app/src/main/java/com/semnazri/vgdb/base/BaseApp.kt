package com.semnazri.vgdb.base

import android.app.Application
import com.orhanobut.hawk.Hawk
import com.semnazri.vgdb.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApp: Application() {

    private val appModules = listOf( networkModule, repositoryModule, domainModule, viewModelModule,localCacheModule)

    override fun onCreate() {
        super.onCreate()
        initHawk()
        initKoin()
    }

    private fun initHawk() {
        Hawk.init(this).build()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@BaseApp)
            modules(appModules)
        }
    }
}
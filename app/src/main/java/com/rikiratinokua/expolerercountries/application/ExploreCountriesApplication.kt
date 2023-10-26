package com.rikiratinokua.expolerercountries.application

import android.app.Application
import com.rikiratinokua.expolerercountries.di.ExploreCountiesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ExploreCountriesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(ExploreCountiesModule)
        }
    }
}
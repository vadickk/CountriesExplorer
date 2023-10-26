package com.rikiratinokua.expolerercountries.di

import com.rikiratinokua.expolerercountries.navigation.CountriesExplorerNavigationRepository
import org.koin.dsl.module

val NavigationModule = module {
    single<CountriesExplorerNavigationRepository> {
        CountriesExplorerNavigationRepository.Base()
    }
}
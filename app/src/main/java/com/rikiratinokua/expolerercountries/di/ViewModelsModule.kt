package com.rikiratinokua.expolerercountries.di

import com.rikiratinokua.expolerercountries.screens.viewmodels.ApplicationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module {
    single {
        ApplicationViewModel(
            countiesService = get(),
            navigationRepository = get()
        )
    }
}
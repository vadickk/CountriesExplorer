package com.rikiratinokua.expolerercountries.navigation

import androidx.navigation.NavController
import com.rikiratinokua.expolerercountries.R

interface CountriesExplorerNavigationRepository {
    fun navigateToCountryDetailsFragment(navController: NavController)

    class Base : CountriesExplorerNavigationRepository {
        override fun navigateToCountryDetailsFragment(navController: NavController) {
            navController.navigate(R.id.actionFromCountriesFragmentToCountryDetailsFragment)
        }
    }
}
package com.rikiratinokua.expolerercountries.screens.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.rikiratinokua.expolerercountries.navigation.CountriesExplorerNavigationRepository
import com.rikiratinokua.expolerercountries.networking.entities.Country
import com.rikiratinokua.expolerercountries.networking.service.CountiesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ApplicationViewModel(
    private val countiesService: CountiesService,
    private val navigationRepository: CountriesExplorerNavigationRepository
) : ViewModel() {

    var countries: MutableLiveData<List<Country>> = MutableLiveData()
    var filteredCountries: MutableLiveData<List<Country>> = MutableLiveData()
    var country = MutableLiveData<Country>()

    fun navigateToDetailsFragment(navController: NavController) {
        navigationRepository.navigateToCountryDetailsFragment(navController)
    }

    fun getAllCountries() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = countiesService.getAllCounties().body()
            result?.let { countries.postValue(it) }
        }
    }

    fun getCountriesByName(nameOfCountry: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = countries.value?.filter { country -> country.name.common.contains(nameOfCountry, ignoreCase = true) }
            Log.d("MyLog", result.toString())
            result?.let { filteredCountries.postValue(it) }
        }
    }
}

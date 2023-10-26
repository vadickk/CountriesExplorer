package com.rikiratinokua.expolerercountries.screens.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.rikiratinokua.expolerercountries.databinding.FragmentCountriesBinding
import com.rikiratinokua.expolerercountries.screens.ui.adapter.CountriesAdapter
import com.rikiratinokua.expolerercountries.screens.viewmodels.ApplicationViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel

class CountriesFragment : Fragment() {
    private val binding by lazy { FragmentCountriesBinding.inflate(layoutInflater) }
    private val viewModel by viewModel<ApplicationViewModel>()
    private val countriesAdapter = CountriesAdapter { country ->
        viewModel.country.value = country
        viewModel.navigateToDetailsFragment(findNavController())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvCountries.adapter = countriesAdapter

        viewModel.countries.observe(viewLifecycleOwner) { countries ->
            countriesAdapter.setNewCountries(countries)
        }

        viewModel.filteredCountries.observe(viewLifecycleOwner) { countries ->
            countriesAdapter.setNewCountries(countries)
        }

        viewModel.getAllCountries()

        binding.countrySearchText.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                if (p0?.isEmpty() == true && p0.isBlank()) {
                    viewModel.getAllCountries()
                } else {
                    viewModel.getCountriesByName(p0.toString())
                }
                return true
            }
        })
    }
}
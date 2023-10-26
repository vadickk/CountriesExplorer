package com.rikiratinokua.expolerercountries.screens.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.rikiratinokua.expolerercountries.databinding.FragmentCountryDetailBinding
import com.rikiratinokua.expolerercountries.screens.viewmodels.ApplicationViewModel
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel

class CountryDetailFragment : Fragment() {
    private val binding by lazy { FragmentCountryDetailBinding.inflate(layoutInflater) }
    private val viewModel by viewModel<ApplicationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val country = viewModel.country.value

        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        Picasso.get().load(country?.flags?.png).into(binding.ivCountry)
        binding.tvCountryName.text = country?.name?.common
        binding.tvCountryCapital.text = try {
            country?.capital?.first()
        } catch (e: Exception) {
            "No Data"
        }
        binding.tvCountryPopulation.text = "Population - ${country?.population} person's"
        binding.tvCountryArea.text = "Area - ${country?.area} km"
        binding.tvCountryContinents.text = "Continents - ${country?.continents?.joinToString()}"
        binding.tvCountryStartOfWeek.text = "Start of week - ${country?.startOfWeek}"
    }
}
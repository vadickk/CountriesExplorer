package com.rikiratinokua.expolerercountries.screens.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rikiratinokua.expolerercountries.R
import com.rikiratinokua.expolerercountries.databinding.ItemCountryBinding
import com.rikiratinokua.expolerercountries.networking.entities.Country
import com.squareup.picasso.Picasso

class CountriesAdapter(
    private val onCountryClickListener: OnCountryClickListener
) : RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder>() {
    private val countries = mutableListOf<Country>()

    inner class CountriesViewHolder(private val binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(country: Country) {
            val capital = try {
                country.capital.first()
            } catch (e: Exception) {
                "No data"
            }
            Picasso.get().load(country.flags.png).into(binding.ivCountry)
            binding.tvCountryName.text = country.name.common
            binding.tvCountryCapital.text = capital
            binding.countryItem.setOnClickListener {
                onCountryClickListener.onClick(country)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val binding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount(): Int = countries.size

    @SuppressLint("NotifyDataSetChanged")
    fun setNewCountries(countriesList: List<Country>) {
        countries.clear()
        countries.addAll(countriesList)
        notifyDataSetChanged()
    }
}

fun interface OnCountryClickListener {
    fun onClick(country: Country)
}

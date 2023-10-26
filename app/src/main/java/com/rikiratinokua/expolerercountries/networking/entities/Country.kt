package com.rikiratinokua.expolerercountries.networking.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country(
    val name: Name,
    val capital: List<String>,
    val flags: Flag,
    val population: String,
    val continents: List<String>,
    val area: String,
    val startOfWeek: String
): Parcelable

@Parcelize
data class Flag(
    val png: String
): Parcelable

@Parcelize
data class Name(
    val common: String,
    val official: String,
    val nativeName: NativeName
): Parcelable

@Parcelize
data class NativeName(
    val ukr: Translations
): Parcelable

@Parcelize
data class Translations(
    val official: String,
    val common: String
): Parcelable

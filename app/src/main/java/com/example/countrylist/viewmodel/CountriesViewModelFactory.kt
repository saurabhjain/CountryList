package com.example.countrylist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.countrylist.repository.CountriesRepository

@Suppress("UNCHECKED_CAST")
class CountriesViewModelFactory(
    private val repository: CountriesRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass != CountriesViewModel::class.java) {
            throw RuntimeException("Wrong Factory class is being used")
        }
        return CountriesViewModel(repository) as T
    }
}
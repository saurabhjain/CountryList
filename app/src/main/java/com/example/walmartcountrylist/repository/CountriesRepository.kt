package com.example.walmartcountrylist.repository

import com.example.walmartcountrylist.apiservice.APIRequest
import com.example.walmartcountrylist.apiservice.CountriesService
import com.example.walmartcountrylist.model.CountryResponseItem
import com.example.walmartcountrylist.utils.Constants
import com.example.walmartcountrylist.utils.NetworkException
import com.example.walmartcountrylist.utils.NoInternetException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CountriesRepository: APIRequest() {

    suspend fun fetchCountriesList(): List<CountryResponseItem> {
        return withContext(Dispatchers.IO) {
            try {
                return@withContext apiRequest { CountriesService().getCountriesData(Constants.ENDPOINT) }
            } catch (e: Exception) {
                throw e
            }
        }
    }

}
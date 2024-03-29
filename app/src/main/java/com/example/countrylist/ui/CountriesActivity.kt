package com.example.countrylist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.countrylist.R
import com.example.countrylist.databinding.ActivityCountriesBinding

class CountriesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCountriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countriesFragment = getFragmentByTag()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, countriesFragment, COUNTRIES_FRAGMENT_TAG)
                .commitNow()
        }
    }

    private fun getFragmentByTag(): CountriesFragment {
        var fragment = supportFragmentManager.findFragmentByTag(COUNTRIES_FRAGMENT_TAG) as? CountriesFragment
        if (fragment == null) {
            fragment = CountriesFragment()
        }
        return fragment
    }

    companion object {
        const val COUNTRIES_FRAGMENT_TAG = "CountriesFragment"
    }
}
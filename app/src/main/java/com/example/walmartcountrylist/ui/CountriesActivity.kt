package com.example.walmartcountrylist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.walmartcountrylist.R
import com.example.walmartcountrylist.databinding.ActivityCountriesBinding
import com.example.walmartcountrylist.utils.isNetworkAvailable

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
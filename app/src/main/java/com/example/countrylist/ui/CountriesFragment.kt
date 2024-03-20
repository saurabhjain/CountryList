package com.example.countrylist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.countrylist.R
import com.example.countrylist.databinding.FragmentCountriesBinding
import com.example.countrylist.repository.CountriesRepository
import com.example.countrylist.utils.isNetworkAvailable
import com.example.countrylist.viewmodel.CountriesViewModel
import com.example.countrylist.viewmodel.CountriesViewModelFactory

class CountriesFragment : Fragment() {

    private var _binding: FragmentCountriesBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val adapter: CountriesListAdapter = CountriesListAdapter()
    private lateinit var viewModel: CountriesViewModel

    override fun onStart() {
        super.onStart()

        val repository = CountriesRepository()
        val factory = CountriesViewModelFactory(repository)
        viewModel = ViewModelProvider(
            context as AppCompatActivity,
            factory
        )[CountriesViewModel::class.java]

        viewModel.countriesData.observe(this, Observer {
            if(0 < it?.size!!) {
                updateView(true)
            } else {
                updateView(false)
            }
            adapter.countriesListItems = it
            adapter.submitList(it)
        })
        if(!isNetworkAvailable(requireContext())) {
            Toast.makeText(requireContext(), getString(R.string.network_not_available), Toast.LENGTH_LONG).show()
            updateView(false)
        } else {
            viewModel.fetchCountriesData()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCountriesBinding.inflate(inflater, container, false)
        val view = binding.root
        val layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        if (binding.recyclerView.layoutManager == null || binding.recyclerView.layoutManager != layoutManager) {
            binding.recyclerView.layoutManager = layoutManager
        }
        binding.recyclerView.adapter = adapter
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun updateView(isDataAvailable: Boolean) {
        if(isDataAvailable) {
            binding.recyclerView.visibility = View.VISIBLE
            binding.progressBar.visibility = View.GONE
            binding.tvEmptyState.visibility = View.GONE
        } else {
            binding.recyclerView.visibility = View.GONE
            binding.progressBar.visibility = View.GONE // Since we are done fetching data and it came out to be of size 0, we can hide the progress bar
            binding.tvEmptyState.visibility = View.VISIBLE
        }
    }

}
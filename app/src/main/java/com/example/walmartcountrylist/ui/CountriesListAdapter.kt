package com.example.walmartcountrylist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.walmartcountrylist.databinding.ListItemBinding
import com.example.walmartcountrylist.model.CountryResponseItem

class CountriesListAdapter: ListAdapter<CountryResponseItem, CountriesVH>(DifferCallback()) {

    var countriesListItems = listOf<CountryResponseItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesVH {
        val itemBinding = ListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CountriesVH(itemBinding)
    }

    override fun onBindViewHolder(holder: CountriesVH, position: Int) {
        val item = countriesListItems[position]
        holder.bind(item)
    }

    override fun getItemCount() = countriesListItems.size

    class DifferCallback: DiffUtil.ItemCallback<CountryResponseItem>() {
        override fun areItemsTheSame(
            oldItem: CountryResponseItem,
            newItem: CountryResponseItem
        ): Boolean {
            return oldItem.code == newItem.code
        }

        override fun areContentsTheSame(
            oldItem: CountryResponseItem,
            newItem: CountryResponseItem
        ): Boolean {
            return oldItem == newItem
        }
    }

}

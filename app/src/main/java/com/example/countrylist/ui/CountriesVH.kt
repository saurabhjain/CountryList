package com.example.countrylist.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.countrylist.R
import com.example.countrylist.databinding.ListItemBinding
import com.example.countrylist.model.CountryResponseItem

class CountriesVH(
    private val itemBinding: ListItemBinding
) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(item: CountryResponseItem) {
        itemBinding.tvCountryNameAndRegion.text = itemView.context.getString(R.string.country_and_region_format, item.name, item.region)
        itemBinding.tvCountryCode.text = item.code
        itemBinding.tvCountryCapital.text = item.capital
    }
}
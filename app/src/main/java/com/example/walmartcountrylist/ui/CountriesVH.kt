package com.example.walmartcountrylist.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.walmartcountrylist.R
import com.example.walmartcountrylist.databinding.ListItemBinding
import com.example.walmartcountrylist.model.CountryResponseItem

class CountriesVH(
    private val itemBinding: ListItemBinding
) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(item: CountryResponseItem) {
        itemBinding.tvCountryNameAndRegion.text = itemView.context.getString(R.string.country_and_region_format, item.name, item.region)
        itemBinding.tvCountryCode.text = item.code
        itemBinding.tvCountryCapital.text = item.capital
    }
}
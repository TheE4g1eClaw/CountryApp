package com.solera.countryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CountryListAdapter(private val countries: List<Country>) :
    RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    inner class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_country_name)
        val tvRegion: TextView = itemView.findViewById(R.id.tv_country_region)
        val imgAvatar: ImageView = itemView.findViewById(R.id.list_flag) // Assuming you have an ImageView for the avatar
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countries[position]
        holder.tvName.text = country.name
        holder.tvRegion.text = country.subregion
    }

    override fun getItemCount(): Int = countries.size
}

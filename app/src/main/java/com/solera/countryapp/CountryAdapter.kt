package com.solera.countryapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


class CountryAdapter (private val country: List<Country>): RecyclerView.Adapter<CountryAdapter.ViewHolder> () {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        //val flags: ImageView = view.findViewById(R.id.flags)
        //val alpha3code: TextView = view.findViewById(R.id.tvName)
        //val name: TextView = view.findViewById(R.id.tvName)
        //val subregion: TextView = view.findViewById(R.id.tvSpecie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_main/*country_item*/, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val __country = country[position]
        //holder.name.text = __country.name
        //holder.subregion.text = --__country.subregion

        /*Glide.with(holder.itemView.context)
            .load(country.image)
            .into(holder.flags)*/
    }

    override fun getItemCount(): Int = country.size
}

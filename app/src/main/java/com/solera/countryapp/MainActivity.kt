package com.solera.countryapp

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.solera.countryapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageView = findViewById<ImageView>(binding.worldImg.id)
        Glide.with(this)
            .asGif()
            .load(R.drawable.planet_gif)
            .into(imageView)
        getCountries()
    }

    private fun getCountries(){
        RetrofitClient.service.getCharacters().enqueue(object : Callback<List<Country>> {
            override fun onResponse(
                call: Call<List<Country>>,
                response: Response<List<Country>>
            ) {
                if (response.isSuccessful) {
                    val countries = response.body() ?: emptyList()
                    val countryNames = countries.map { it.name }
                    //Log.d("MainActivity", "Countries: $countryNames")

                    val adapter = ArrayAdapter(
                        this@MainActivity,
                        android.R.layout.simple_list_item_1,
                        countryNames
                    )
                    binding.countryName.setAdapter(adapter)
                }
            }

            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                Toast.makeText(this@MainActivity,  "Error al conectar", Toast.LENGTH_LONG).show()
            }
        })
    }
}
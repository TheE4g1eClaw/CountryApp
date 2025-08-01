package com.solera.countryapp

import android.content.Intent
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
    private var countries: List<Country> = emptyList() // Hacemos esto global

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "OnCreate ejecutando")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // GIF
        val imageView = findViewById<ImageView>(binding.worldImg.id)
        Glide.with(this)
            .asGif()
            .load(R.drawable.planet_gif)
            .into(imageView)

        getCountries()

        // Listener del botón buscar
        binding.searchBtn.setOnClickListener {
            val inputName = binding.countryName.text.toString()
            val selectedCountry = countries.find { it.name.equals(inputName, ignoreCase = true) }

            if (selectedCountry != null) {
                val intent = Intent(this@MainActivity, CountryDetailActivity::class.java).apply {
                    putExtra("name", selectedCountry.name)
                    putExtra("region", selectedCountry.subregion)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "País no encontrado", Toast.LENGTH_SHORT).show()
            }
        }

        binding.countryListBtn.setOnClickListener {
            val intent = Intent(this, CountryListActivity::class.java)
            startActivity(intent)
        }

    }

    private fun getCountries() {
        RetrofitClient.service.getContries().enqueue(object : Callback<List<Country>> {
            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                if (response.isSuccessful) {
                    countries = response.body() ?: emptyList()
                    val countryNames = countries.map { it.name }.sorted()

                    Log.d("MainActivity", "Países: $countryNames")

                    val adapter = ArrayAdapter(
                        this@MainActivity,
                        android.R.layout.simple_list_item_1,
                        countryNames
                    )
                    binding.countryName.setAdapter(adapter)
                } else {
                    Log.e("MainActivity", "Error en respuesta: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                Log.e("MainActivity", "Error en la conexión", t)
                Toast.makeText(this@MainActivity, "Error al conectar", Toast.LENGTH_LONG).show()
            }
        })
    }
}

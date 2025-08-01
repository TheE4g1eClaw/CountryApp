
package com.solera.countryapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_list)

        recyclerView = findViewById(R.id.recycler_view)
        backButton = findViewById(R.id.back_button)

        backButton.setOnClickListener {
            finish() // Regresar a la pantalla anterior
        }

        getAllCountries()
    }

    private fun getAllCountries() {
        RetrofitClient.service.getContries().enqueue(object : Callback<List<Country>> {
            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                if (response.isSuccessful) {
                    val countries = response.body() ?: emptyList()
                    recyclerView.layoutManager = LinearLayoutManager(this@CountryListActivity)
                    recyclerView.adapter = CountryListAdapter(countries)
                } else {
                    Toast.makeText(
                        this@CountryListActivity,
                        "Failed to load countries",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                Log.e("CountryListActivity", "API error", t)
                Toast.makeText(
                    this@CountryListActivity,
                    "Error connecting to server",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}

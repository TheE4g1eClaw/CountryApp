package com.solera.countryapp

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.solera.countryapp.databinding.ActivityCountryDetailBinding


class CountryDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCountryDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountryDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtener datos del intent
        val name = intent.getStringExtra("name")
        val region = intent.getStringExtra("region")
        val image = intent.getStringExtra("flag")
        Log.d("Image_URL", image ?: "No se muestra")
        Glide.with(this)
            .load(image)
            .into(binding.flagView)


        // Mostrar en pantalla
        binding.textCountryName.text = "Nombre: $name"
        binding.textRegion.text = "Región: $region"
        binding.backButton.setOnClickListener {
            finish() // Go back to the previous screen
        }
    }
}


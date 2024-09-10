package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fuelcalculator.databinding.ActivityPriceBinding

class PriceActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityPriceBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.BtPrice.setOnClickListener {
            val kilometers = intent.getFloatExtra("EXTRA_KILOMETERS", 0f) // Recebe os quilômetros
            val liters = intent.getFloatExtra("EXTRA_LITERS", 0f)         // Recebe os litros
            val pricePerLiterText = binding.campoPrice.text.toString()

            if (pricePerLiterText.isEmpty()) {
                Toast.makeText(this@PriceActivity, "Por favor, informe o preço por litro", Toast.LENGTH_SHORT).show()
            } else {
                val pricePerLiter = pricePerLiterText.toFloat()
                val consumption = kilometers / liters // Calcula o consumo médio
                val totalCost = liters * pricePerLiter // Calcula o custo total

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("EXTRA_CONSUMPTION", consumption) // Passa o consumo médio
                intent.putExtra("EXTRA_COST", totalCost)          // Passa o custo total
                intent.putExtra("EXTRA_DISTANCE", kilometers)     // Passa a distância percorrida
                intent.putExtra("EXTRA_FUEL_PRICE", pricePerLiter)// Passa o preço do combustível
                startActivity(intent)
            }
        }

    }
}
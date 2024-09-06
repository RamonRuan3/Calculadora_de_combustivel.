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
            val kilometers = intent.getFloatExtra("EXTRA_KILOMETERS", 0f)
            val liters = intent.getFloatExtra("EXTRA_LITERS", 0f)
            val pricePerLiterText = binding.campoPrice.text.toString()

            // Verifica se o campo de preço por litro está vazio
            if (pricePerLiterText.isEmpty()) {
                Toast.makeText(this@PriceActivity, "Por favor, informe o preço por litro", Toast.LENGTH_SHORT).show()
            } else {
                // Continua com os cálculos se o campo não estiver vazio
                val pricePerLiter = pricePerLiterText.toFloat()

                val consumption = kilometers / liters
                val totalCost = liters * pricePerLiter

                // Cria o Intent fora do apply
                val intent = Intent(this, ResultActivity::class.java)

                // Coloca os extras dentro do apply
                intent.apply {
                    putExtra("EXTRA_CONSUMPTION", consumption)
                    putExtra("EXTRA_COST", totalCost)
                }

                // startActivity agora está fora do bloco apply
                startActivity(intent)
            }
        }


    }
}
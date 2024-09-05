package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fuelcalculator.databinding.ActivityPriceBinding

class PriceActivity : AppCompatActivity() {
    private val binding by lazy{
        ActivityPriceBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.BtPrice.setOnClickListener {

            val intent = Intent( this, ResultActivity::class.java).apply {
                val kilometers = intent.getFloatExtra("EXTRA_KILOMETERS", 0f)
                val liters = intent.getFloatExtra("EXTRA_LITERS", 0f)
                val pricePerLiter = binding.campoPrice.text.toString().toFloat()

                val consumption = kilometers / liters
                val totalCost = liters * pricePerLiter

                putExtra("EXTRA_CONSUMPTION", consumption)
                putExtra("EXTRA_COST", totalCost)
            }
            startActivity(intent)
        }

    }
}
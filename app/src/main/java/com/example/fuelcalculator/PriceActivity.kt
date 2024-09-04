package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PriceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_price)
        val inputPrice: EditText = findViewById(R.id.campoPrice)
        val nextPEButton: Button = findViewById(R.id.Bt_Price)


        nextPEButton.setOnClickListener {

            // Criando um Intent para passar os dados para a próxima tela
            val intent = Intent(this, ResultActivity::class.java).apply {
                val kilometers = intent.getFloatExtra("EXTRA_KILOMETERS", 0f)
                val liters = intent.getFloatExtra("EXTRA_LITERS", 0f)
                val pricePerLiter = inputPrice.text.toString().toFloat()
                val consumption = kilometers / liters
                val totalCost = liters * pricePerLiter

                putExtra("EXTRA_CONSUMPTION", consumption)
                putExtra("EXTRA_COST", totalCost)
            }
            startActivity(intent)
        }
    }
}
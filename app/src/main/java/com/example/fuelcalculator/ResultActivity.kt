package com.example.fuelcalculator

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        val consumption = intent.getFloatExtra("EXTRA_CONSUMPTION", 0f)
        val totalCost = intent.getFloatExtra("EXTRA_COST", 0f)

        val resultConsumption: TextView = findViewById(R.id.resultConsumption)
        val resultCost: TextView = findViewById(R.id.resultCost)

        resultConsumption.text = "Consumo médio: %.2f km/l".format(consumption)
        resultCost.text = "Custo total: R$ %.2f".format(totalCost)
        }
    }

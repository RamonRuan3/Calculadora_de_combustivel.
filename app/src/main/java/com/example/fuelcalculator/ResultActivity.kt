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
        setContentView(R.layout.activity_result)

        val consumption = intent.getFloatExtra("EXTRA_CONSUMPTION", 0f)  // Recebe o consumo médio
        val totalCost = intent.getFloatExtra("EXTRA_COST", 0f)           // Recebe o custo total
        val distance = intent.getFloatExtra("EXTRA_DISTANCE", 0f)        // Recebe a distância percorrida
        val fuelPrice = intent.getFloatExtra("EXTRA_FUEL_PRICE", 0f)     // Recebe o preço do combustível

        // Atualiza os TextViews com os resultados
        val resultConsumption: TextView = findViewById(R.id.resultConsumption)
        val resultCost: TextView = findViewById(R.id.resultCost)
        val resultDistance: TextView = findViewById(R.id.resultDistance)
        val resultPrice: TextView = findViewById(R.id.resultPrice)

        resultConsumption.text = "Consumo médio: %.2f km/l".format(consumption)
        resultCost.text = "Custo total: R$ %.2f".format(totalCost)
        resultDistance.text = "Distância percorrida: %.2f km".format(distance)
        resultPrice.text = "Preço do combustível: R$ %.2f".format(fuelPrice)
    }
}

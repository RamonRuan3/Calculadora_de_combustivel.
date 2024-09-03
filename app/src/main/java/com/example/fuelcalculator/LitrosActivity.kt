package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class LitrosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_litros)
        val inputLiters = findViewById<TextInputEditText>(R.id.campoLitros)
        val nextLtButton = findViewById<Button>(R.id.Bt_litros)

        nextLtButton.setOnClickListener {
            val liters = inputLiters.text.toString().toFloat()
            val kilometers = intent.getFloatExtra("EXTRA_KILOMETERS", 0f)

            // Criando um Intent para passar os dados para a próxima tela
            val intent = Intent(this, PriceActivity::class.java).apply {
                putExtra("EXTRA_KILOMETERS", kilometers)
                putExtra("EXTRA_LITERS", liters)}
                startActivity(intent)
            }

        }
    }

package com.example.fuelcalculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class KMActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_km)
        val inputKM = findViewById<TextInputEditText>(R.id.campoKM)
        val nextKMButton = findViewById<Button>(R.id.Bt_KM)

        nextKMButton.setOnClickListener {
            val kilometers = inputKM.text.toString().toFloat()
            intent.putExtra("EXTRA_KILOMETERS", kilometers)
            val intent = Intent(this, LitrosActivity::class.java)

            startActivity(intent)}
        }
    }








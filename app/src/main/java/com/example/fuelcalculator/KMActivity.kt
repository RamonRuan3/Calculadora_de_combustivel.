package com.example.fuelcalculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
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
            val intent = Intent(this, LitrosActivity::class.java)
            val kilometersv: String= inputKM.text.toString()

            if(kilometersv=="") {
                Snackbar.make(
                    inputKM,
                    "Informe a quilometragem", Snackbar.LENGTH_LONG)
                    .show()

            } else{
                    val kilometers= inputKM.text.toString().toFloat()

                intent.putExtra("EXTRA_KILOMETERS", kilometers)
                startActivity(intent)
             }
        }

    }
}









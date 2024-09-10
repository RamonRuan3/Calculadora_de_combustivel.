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
    import com.google.android.material.textfield.TextInputEditText

    class LitrosActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_litros)
            val inputLiters = findViewById<TextInputEditText>(R.id.campoLitros)
            val nextLtButton = findViewById<Button>(R.id.Bt_litros)

            nextLtButton.setOnClickListener {

                // Criando um Intent para passar os dados para a próxima tela
                nextLtButton.setOnClickListener {
                    val inputLitersText = inputLiters.text.toString()

                    if (inputLitersText.isEmpty()) {
                        Toast.makeText(this, "Por favor, informe a quantidade de litros", Toast.LENGTH_SHORT).show()
                    } else {
                        val liters = inputLitersText.toFloat()
                        val kilometers = intent.getFloatExtra("EXTRA_KILOMETERS", 0f) // Recebe os quilômetros da tela anterior

                        val intent = Intent(this, PriceActivity::class.java)
                        intent.putExtra("EXTRA_KILOMETERS", kilometers) // Passa os quilômetros para a próxima tela
                        intent.putExtra("EXTRA_LITERS", liters)         // Passa os litros para a próxima tela
                        startActivity(intent)
                    }
                }
            }
        }
    }

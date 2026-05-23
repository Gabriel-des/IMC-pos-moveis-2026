package com.example.imc_pos_moveis_2026

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var etPeso: EditText
    private lateinit var etAltura: EditText
    private lateinit var tvResultado: TextView
    private lateinit var btCalcular: Button
    private lateinit var btLimpar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etPeso = findViewById(R.id.etPeso)
        etAltura = findViewById(R.id.etAltura)
        tvResultado = findViewById(R.id.tvResultado)
        btCalcular = findViewById(R.id.btCalcular)
        btLimpar = findViewById(R.id.btLimpar)

        btCalcular.setOnClickListener {
            btCalcularOnclick()
        }

        btCalcular.setOnLongClickListener {
            Toast.makeText(
                this,
                getString(R.string.calcular_clique_longo),
                Toast.LENGTH_LONG
            ).show()

            true
        }

        btLimpar.setOnClickListener {
            btLimparOnClick()
        }
    }

    private fun btCalcularOnclick() {
        val convertedPeso = etPeso.text.toString().toDoubleOrNull()
        val convertedAltura = etAltura.text.toString().toDoubleOrNull()

        if (convertedPeso == null) {
            etPeso.error = getString(R.string.erro_peso)
            return
        }

        if (convertedAltura == null) {
            etAltura.error = getString(R.string.erro_altura)
            return
        }

        if (convertedAltura == 0.0) {
            etAltura.error = getString(R.string.erros_zeros_altura)
            return
        }

        val imc = convertedPeso / convertedAltura.pow(2)

        tvResultado.text = "%.2f".format(imc)
    }

    private fun btLimparOnClick() {
        etPeso.setText("")
        etAltura.setText("")

        tvResultado.text = getString(R.string.zeros)

        etPeso.requestFocus()
    }
}
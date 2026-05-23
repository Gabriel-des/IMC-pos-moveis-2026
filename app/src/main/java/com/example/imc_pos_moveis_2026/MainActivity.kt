package com.example.imc_pos_moveis_2026

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.NumberFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var etPeso: EditText
    private lateinit var etAltura: EditText
    private lateinit var tvResultado: TextView
    private lateinit var tvClassificacao: TextView
    private lateinit var btCalcular: Button
    private lateinit var btLimpar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setupWindowInsets()
        setupViews()
        setupObservers()
        setupListeners()
    }

    private fun setupWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun setupViews() {
        etPeso = findViewById(R.id.etPeso)
        etAltura = findViewById(R.id.etAltura)
        tvResultado = findViewById(R.id.tvResultado)
        tvClassificacao = findViewById(R.id.tvClassificacao)
        btCalcular = findViewById(R.id.btCalcular)
        btLimpar = findViewById(R.id.btLimpar)
    }

    private fun setupObservers() {
        viewModel.bmiResult.observe(this) { result ->
            tvResultado.text = formatarResultado(result.imc)
            tvClassificacao.text = getString(result.classificationResId)
        }
    }

    private fun setupListeners() {
        btCalcular.setOnClickListener {
            val peso = etPeso.text.toString().toDoubleOrNull()
            val altura = etAltura.text.toString().toDoubleOrNull()

            if (validarCampos(peso, altura)) {
                viewModel.calcular(peso!!, altura!!, Locale.getDefault().language)
            }
        }

        btCalcular.setOnLongClickListener {
            Toast.makeText(this, getString(R.string.calcular_clique_longo), Toast.LENGTH_LONG).show()
            true
        }

        btLimpar.setOnClickListener {
            limparCampos()
        }
    }

    private fun validarCampos(peso: Double?, altura: Double?): Boolean {
        if (peso == null) {
            etPeso.error = getString(R.string.erro_peso)
            return false
        }
        if (altura == null) {
            etAltura.error = getString(R.string.erro_altura)
            return false
        }
        if (altura == 0.0) {
            etAltura.error = getString(R.string.erros_zeros_altura)
            return false
        }
        return true
    }

    private fun formatarResultado(imc: Double): String {
        val nf = NumberFormat.getNumberInstance(Locale.getDefault())
        nf.minimumFractionDigits = 2
        nf.maximumFractionDigits = 2
        return nf.format(imc)
    }

    private fun limparCampos() {
        etPeso.setText("")
        etAltura.setText("")
        tvResultado.text = getString(R.string.zeros)
        tvClassificacao.text = ""
        etPeso.requestFocus()
    }
}

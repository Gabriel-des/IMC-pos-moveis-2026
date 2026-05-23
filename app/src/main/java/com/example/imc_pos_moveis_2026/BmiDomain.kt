package com.example.imc_pos_moveis_2026

import kotlin.math.pow

object BmiDomain {

    fun calcularIMC(peso: Double, altura: Double, idioma: String): Double {
        return if (idioma == "en") {
            703 * (peso / altura.pow(2))
        } else {
            peso / altura.pow(2)
        }
    }

    fun classificarIMC(imc: Double): Int {
        return when {
            imc < 18.5 -> R.string.abaixo_peso
            imc < 25.0 -> R.string.peso_normal
            imc < 30.0 -> R.string.sobrepeso
            imc < 35.0 -> R.string.obesidade_grau_1
            imc < 40.0 -> R.string.obesidade_grau_2
            else -> R.string.obesidade_grau_3
        }
    }
}

package com.example.imc_pos_moveis_2026

import org.junit.Test
import org.junit.Assert.*

class ExampleUnitTest {

    @Test
    fun calcularIMC_metrico_isCorrect() {
        val resultado = BmiDomain.calcularIMC(90.0, 1.9, "pt")
        assertEquals(24.93, resultado, 0.01)
    }

    @Test
    fun classificarIMC_isCorrect() {
        // Teste de algumas faixas
        assertEquals(R.string.abaixo_peso, BmiDomain.classificarIMC(17.0))
        assertEquals(R.string.peso_normal, BmiDomain.classificarIMC(22.0))
        assertEquals(R.string.sobrepeso, BmiDomain.classificarIMC(27.0))
        assertEquals(R.string.obesidade_grau_1, BmiDomain.classificarIMC(32.0))
    }

    @Test
    fun calcularIMC_imperial_isCorrect() {
        val resultado = BmiDomain.calcularIMC(150.0, 70.0, "en")
        assertEquals(21.52, resultado, 0.01)
    }

    @Test
    fun calcularIMC_altura_zero_retorna_infinito() {
        val resultado = BmiDomain.calcularIMC(70.0, 0.0, "pt")
        assertTrue(resultado.isInfinite())
    }
}

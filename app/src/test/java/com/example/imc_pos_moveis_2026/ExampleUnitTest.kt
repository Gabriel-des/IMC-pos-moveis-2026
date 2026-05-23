package com.example.imc_pos_moveis_2026

import org.junit.Test
import org.junit.Assert.*

class ExampleUnitTest {

    @Test
    fun calcularIMC_metrico_isCorrect() {
        val resultado = MainActivity.calcularIMC(90.0, 1.9, "pt")
        assertEquals(24.93, resultado, 0.01)
    }

    @Test
    fun calcularIMC_imperial_isCorrect() {
        val resultado = MainActivity.calcularIMC(150.0, 70.0, "en")
        assertEquals(21.52, resultado, 0.01)
    }

    @Test
    fun calcularIMC_limite_abaixo_peso() {
        val resultado = MainActivity.calcularIMC(50.0, 1.8, "pt")
        assertTrue(resultado < 18.5)
    }

    @Test
    fun calcularIMC_limite_sobrepeso() {
        val resultado = MainActivity.calcularIMC(85.0, 1.7, "pt")
        assertTrue(resultado in 25.0..29.9)
    }

    @Test
    fun calcularIMC_altura_zero_retorna_infinito() {
        val resultado = MainActivity.calcularIMC(70.0, 0.0, "pt")
        assertTrue(resultado.isInfinite())
    }
}

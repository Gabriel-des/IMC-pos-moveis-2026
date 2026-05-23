package com.example.imc_pos_moveis_2026

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class BmiResult(
    val imc: Double,
    val classificationResId: Int
)

class MainViewModel : ViewModel() {

    private val _bmiResult = MutableLiveData<BmiResult>()
    val bmiResult: LiveData<BmiResult> = _bmiResult

    fun calcular(peso: Double, altura: Double, idioma: String) {
        val imc = BmiDomain.calcularIMC(peso, altura, idioma)
        val classificationId = BmiDomain.classificarIMC(imc)
        
        _bmiResult.value = BmiResult(imc, classificationId)
    }
}

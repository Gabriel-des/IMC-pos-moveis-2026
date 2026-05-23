package com.example.imc_pos_moveis_2026

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun erroPesoVazio() {
        onView(withId(R.id.btCalcular)).perform(click())
        onView(withId(R.id.etPeso)).check(matches(hasErrorText("Campo peso deve ser preenchido.")))
    }

    @Test
    fun erroAlturaVazia() {
        onView(withId(R.id.etPeso)).perform(typeText("70"), closeSoftKeyboard())
        onView(withId(R.id.btCalcular)).perform(click())
        onView(withId(R.id.etAltura)).check(matches(hasErrorText("Campo altura deve ser preenchido.")))
    }

    @Test
    fun erroAlturaZero() {
        onView(withId(R.id.etPeso)).perform(typeText("70"), closeSoftKeyboard())
        onView(withId(R.id.etAltura)).perform(typeText("0"), closeSoftKeyboard())
        onView(withId(R.id.btCalcular)).perform(click())
        onView(withId(R.id.etAltura)).check(matches(hasErrorText("Altura não pode ser 0.")))
    }

    @Test
    fun calculoSucesso() {
        onView(withId(R.id.etPeso)).perform(typeText("80"), closeSoftKeyboard())
        onView(withId(R.id.etAltura)).perform(typeText("1.80"), closeSoftKeyboard())
        onView(withId(R.id.btCalcular)).perform(click())
        
        // Verifica se o resultado não é o valor inicial "0,00"
        onView(withId(R.id.tvResultado)).check(matches(isDisplayed()))
        onView(withId(R.id.tvResultado)).check(matches(withText("24,69")))
    }
}

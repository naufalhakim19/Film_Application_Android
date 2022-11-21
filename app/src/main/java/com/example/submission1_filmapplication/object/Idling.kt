package com.example.submission1_filmapplication.`object`

import androidx.test.espresso.idling.CountingIdlingResource

object Idling {
    private const val RESOURCE = "GLOBAL"
    val idling = CountingIdlingResource(RESOURCE)

    fun decrement() {
        idling.decrement()
    }

    fun increment() {
        idling.increment()
    }
}

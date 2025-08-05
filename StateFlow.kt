package com.example.coroutinesstart

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    val counter = MutableStateFlow(0)

    // Collector
    launch {
        counter.collect {
            println("Counter value: $it")
        }
    }

    // Updater
    launch {
        delay(500)
        counter.value = 1
        delay(500)
        counter.value = 2
    }

    delay(2000)
}

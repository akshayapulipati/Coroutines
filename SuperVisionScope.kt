package com.example.coroutinesstart
import kotlinx.coroutines.*
suspend fun example() = supervisorScope {
    val job = launch {
        try {
            throw RuntimeException("Crash in Job!")
        } catch (e: Exception) {
            println("Caught: ${e.message}")
        }
    }

    val job2 = launch {
        delay(300)
        println("Job2 still runs")
    }
}

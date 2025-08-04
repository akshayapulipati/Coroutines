package com.example.coroutinesstart

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch {
        try {
            println(" Working...")
            delay(500)
            throw RuntimeException("Something went wrong!")
        } catch (e: Exception) {
            println(" Caught exception: ${e.message}")
        }
    }
    job.join()
}

package com.example.coroutinesstart

import kotlinx.coroutines.*

fun main() = runBlocking {
    try {
        withTimeout(1500) { // Set a 1.5s timeout
            repeat(5) {
                println(" Working $it")
                delay(500) // 0.5s each
            }
        }
    } catch (e: TimeoutCancellationException) {
        println("Timed out!")
    }
}

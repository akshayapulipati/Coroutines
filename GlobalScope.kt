package com.example.coroutinesstart

import kotlinx.coroutines.*
fun main() {
    val job = GlobalScope.launch {
        println("Loading")
        delay(5000)
        println("done job")
    }

    Thread.sleep(2000)
    println("Cancelling job...")
    job.cancel()
    Thread.sleep(4000) // Wait to show that job is cancelled
}


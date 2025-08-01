package com.example.coroutinesstart

import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Main starts on: ${Thread.currentThread().name}")

    val data = withContext(Dispatchers.IO) {
        println("Fetching data on: ${Thread.currentThread().name}")
        delay(1000)  // Simulate I/O operation
        "Data from server"
    }

    println("Received: $data")
    println("Main ends on: ${Thread.currentThread().name}")
}

package com.example.coroutinesstart

import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Main Program starts: ${Thread.currentThread().name}\n")

    launch(Dispatchers.Default) {
        println("Default Dispatcher (CPU-Intensive task): ${Thread.currentThread().name}")
    }

    launch(Dispatchers.IO) {
        println("IO Dispatcher (I/O Task): ${Thread.currentThread().name}")
    }

    launch(Dispatchers.Unconfined) {
        println("Unconfined Dispatcher (starts on caller thread): ${Thread.currentThread().name}")
    }

    println("\nMain Program ends: ${Thread.currentThread().name}")
}

package com.example.coroutinesstart

import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Main starts: ${Thread.currentThread().name}")

    launch {
        delay(1000)
        println("Inside coroutine: ${Thread.currentThread().name}")
    }

    println("Main ends: ${Thread.currentThread().name}")
}

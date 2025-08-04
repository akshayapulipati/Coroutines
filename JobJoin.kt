package com.example.coroutinesstart

import kotlinx.coroutines.*
fun main() = runBlocking {
    println("main starst on threadA${Thread.currentThread().name}")
    val job =launch(Dispatchers.Default){
        println("Background task running on thread:${Thread.currentThread().name}")
        delay(2000)// Simulate some work
        println("background task done")
    }
    println("main waiting for job to finish")
    job.join()// Wait for the background coroutine to complete
    println("main resumes after job.join")
}
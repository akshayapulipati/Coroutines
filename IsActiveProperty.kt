package com.example.coroutinesstart

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch {
        repeat(10){i ->
            if(isActive){
                println("coroutine was cancelled at iteration $i")
                return@launch
            }
            println("Working on $i")
            delay(300)
        }
    }
    delay(1000)
    job.cancel()
}
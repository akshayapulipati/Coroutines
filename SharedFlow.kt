package com.example.coroutinesstart

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    val sharedFlow = MutableSharedFlow<String>(replay = 1)

    // Emitter
    launch {
        delay(100)
        sharedFlow.emit("Event 1")
        delay(100)
        sharedFlow.emit("Event 2")
    }

    // Collector 1
    launch {
        sharedFlow.collect {
            println("Collector 1: $it")
        }
    }

    // Collector 2 joins later
    launch {
        delay(300)
        sharedFlow.collect {
            println("Collector 2: $it")
        }
    }

    delay(500)
}

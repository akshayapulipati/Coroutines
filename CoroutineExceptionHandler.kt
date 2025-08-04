package com.example.coroutinesstart

import kotlinx.coroutines.*

fun main() = runBlocking {
    val handler = CoroutineExceptionHandler { _, exception ->
        println(" Caught by handler: ${exception.message}")
    }

    val job = launch(handler) {
        throw RuntimeException(" Crash in coroutine")
    }

    job.join()
}

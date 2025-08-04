package com.example.coroutinesstart
import kotlinx.coroutines.*
fun main() = runBlocking {
    val handler = CoroutineExceptionHandler { _, exception ->
        println("Caught exception: ${exception.message}")
    }

    val deferred = async(handler) {
        throw RuntimeException("Error in async")
    }

    try {
        deferred.await()
    } catch (e: Exception) {
        println("Caught manually: ${e.message}")
    }
}

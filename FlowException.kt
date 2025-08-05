package com.example.coroutinesstart

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*


fun errorFlow(): Flow<Int> = flow {
    emit(1)
    emit(2)
    throw Exception("Something went wrong")
    emit(3)
}

fun main() = runBlocking {
    errorFlow()
        .onCompletion { println("Flow completed") }
        .catch { e -> println("Caught error: ${e.message}") }
        .collect { println("Collected: $it") }
}

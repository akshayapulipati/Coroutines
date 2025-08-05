package com.example.coroutinesstart

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    simpleFlow().collect{ value ->
        println("Received:$value")
    }
}
fun simpleFlow():Flow<Int> =flow{
    for(i in 1..5){
        delay(1000)
        emit(i)
    }
}
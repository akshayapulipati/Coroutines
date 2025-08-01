package com.example.coroutinesstart

import kotlinx.coroutines.*

//runBlocking blocks main thread until coroutine completes
fun main()=runBlocking{
    launch{//starts a new coroutine
        delay(1000)//suspends (non-blocks) for 1 second.
        println("World")
    }
    println("Hello")
}
package com.example.coroutinesstart

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class DataFetcher : CoroutineScope {
    private val job =Job()
    // Defineing the scope with a dispatcher and job
    override val coroutineContext = Dispatchers.IO+job

    fun fetchDta(){
        launch {
            println("fetching data:${Thread.currentThread().name}")
            delay(2000)
            println("Data fetched")
        }
    }
    fun cancelAll(){
        println("Cncelling fetcher")
        job.cancel()// cancels all coroutines in this scope
    }
}
fun main(){
    val fetcher=DataFetcher()
    fetcher.fetchDta()

    Thread.sleep(1000)
    fetcher.cancelAll()  // Will cancel before the 2-second delay finishes
    Thread.sleep(2000) // Give time to see if anything prints

}
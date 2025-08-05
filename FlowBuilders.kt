import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    println(" flow builder example:")
    customFlow().collect { println("flow: $it") }

    println("\n flowOf builder example:")
    flowOfExample().collect { println("flowOf: $it") }

    println("\n asFlow builder example:")
    asFlowExample().collect { println("asFlow: $it") }

    println("\n channelFlow builder example:")
    channelFlowExample().collect { println("channelFlow: $it") }
}

//  flow { } – emits values manually
fun customFlow(): Flow<Int> = flow {
    emit(1)
    delay(100)
    emit(2)
    delay(100)
    emit(3)
}

//  flowOf(...) – emits fixed values
fun flowOfExample(): Flow<String> = flowOf("A", "B", "C")

//  asFlow() – converts collection to flow
fun asFlowExample(): Flow<String> = listOf("Red", "Green", "Blue").asFlow()

// channelFlow { } – allows concurrent emission
fun channelFlowExample(): Flow<String> = channelFlow {
    launch {
        delay(200)
        send("From Coroutine A")
    }

    launch {
        delay(100)
        send("From Coroutine B")
    }
}

package com.example.coroutinesstart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    val job = viewModelScope.launch {
        delay(5000) // Simulate some long-running work
        println("✅ Job completed")
    }

    override fun onCleared() {
        super.onCleared()
        println("🧹 ViewModel destroyed — coroutine automatically cancelled")
    }
}

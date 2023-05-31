package com.example.hw1756

import kotlinx.coroutines.*

fun main() = runBlocking {
    val timeoutMillis = 2000L // Желаемое время ожидания

    try {
        val n = 10 // Желаемый номер в последовательности Фибоначчи
        val fibonacciNumber = Fibonacci.take(n, timeoutMillis)
        println("Рассчитанное значение элемента #$n: $fibonacciNumber")
    } catch (e: TimeoutCancellationException) {
        println("Превышение времени ожидания выполнения корутины, срабатывание блока 'catch'")
    }
}